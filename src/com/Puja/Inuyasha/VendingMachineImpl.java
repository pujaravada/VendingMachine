package com.Puja.Inuyasha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {

// cash = coin
// Product = Item

    private Inventory<Cash> cashInventory = new Inventory<Cash>();
    private Inventory<Product> itemInventory = new Inventory<Product>();
    private long totalSales;
    private Product currentItem;
    private long currentBalance;

    public VendingMachineImpl(){
        initialize();
    }

    private void initialize(){
        //initialize machine with 5 coins of each denomination
        //and 5 cans of each Item
        for(Cash c : Cash.values()){
            cashInventory.put(c, 5);
        }

        for(Product i : Product.values()){
            itemInventory.put(i, 5);
        }

    }

    public long selectItemAndGetPrice(Product item) {
        if(itemInventory.hasItem(item)){
            currentItem = item;
            return currentItem.getPrice();
        }
        System.out.println("Sold Out, Please buy another item");
        return 0;
    }

    public void insertCoin(Cash coin) {
        currentBalance = currentBalance + coin.getDenomination();
        cashInventory.add(coin);
    }

    public Store<Product, List<Cash>> collectItemAndChange() {
        Product item = collectItem();
        totalSales = totalSales + currentItem.getPrice();

        List<Cash> change = collectChange();

        return new Store<Product, List<Cash>>(item, change);
    }

    public void reset(){
        cashInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        currentItem = null;
        currentBalance = 0;
    }

    private boolean isFullPaid() {
        if(currentBalance >= currentItem.getPrice()){
            return true;
        }
        return false;
    }

    private List<Cash> getChange(long amount) throws InsufficientChangeException {
        List<Cash> changes = Collections.EMPTY_LIST;

        if(amount > 0){
            changes = new ArrayList<Cash>();
            long balance = amount;
            while(balance > 0){
                if(balance >= Cash.QUARTER.getDenomination()
                        && cashInventory.hasItem(Cash.QUARTER)){
                    changes.add(Cash.QUARTER);
                    balance = balance - Cash.QUARTER.getDenomination();
                    continue;

                }else if(balance >= Cash.DIME.getDenomination()
                        && cashInventory.hasItem(Cash.DIME)) {
                    changes.add(Cash.DIME);
                    balance = balance - Cash.DIME.getDenomination();
                    continue;

                }else if(balance >= Cash.NICKLE.getDenomination()
                        && cashInventory.hasItem(Cash.NICKLE)) {
                    changes.add(Cash.NICKLE);
                    balance = balance - Cash.NICKLE.getDenomination();
                    continue;

                }else if(balance >= Cash.PENNY.getDenomination()
                        && cashInventory.hasItem(Cash.PENNY)) {
                    changes.add(Cash.PENNY);
                    balance = balance - Cash.PENNY.getDenomination();
                    continue;

                }else{
                    throw new InsufficientChangeException("NotSufficientChange,Please try another product");
                }
            }
        }

        return changes;
    }

    private Product collectItem() throws InsufficientChangeException, IncompletePaymentException {
        if(isFullPaid()){
                itemInventory.deduct(currentItem);
                return currentItem;
        }
        long remainingBalance = currentItem.getPrice() - currentBalance;
        throw new IncompletePaymentException("Price not full paid, remaining : ",
                remainingBalance);
    }

    private List<Cash> collectChange() {
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Cash> change = getChange(changeAmount);
        //updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }



}
