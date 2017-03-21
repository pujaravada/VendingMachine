package com.Puja.Inuyasha;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Puja on 3/21/17.
 */
public class Main {


    public static void main(String[] args){

        VendingMachineImpl vendingMachine = new VendingMachineImpl();

        System.out.println("Pick the item you want : Coke|Pepsi|Fanta|Sprite");
        Scanner scanner = new Scanner(System.in);
        String product = scanner.next();


        long currentPrice = vendingMachine.selectItemAndGetPrice(Product.valueOf(product.toUpperCase()));
        System.out.println("Price of item in cents is: "+currentPrice);


        //Decide if you want to purchase or cancel
        System.out.println("------------------");
        System.out.println("Purchase? Press P");
        System.out.println("Cancel? Press C");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        while(!valueEntered(choice)){

            //if invalid value is entered
            System.out.println("Enter valid 'P' or 'C'");
            choice = sc.nextLine();
        }

        // P is pressed for Purchase
        if(choice.equalsIgnoreCase("P")){



            System.out.println("Please insert coins:");
            System.out.println("Choose and enter coins: (PENNY, NICKLE, DIME, QUARTER)");

            // Enter number of coins you want to insert into machine
            System.out.println("How many coins do you want to insert?");
            Scanner coinCountInput = new Scanner(System.in);
            int coinCount = coinCountInput.nextInt();

            //store coins in coin array
            //read from std console
            System.out.println("Insert your coins");
            String[] coinsArray = new String[coinCount];
            Scanner coinsInput = new Scanner(System.in);
            for(int j=0;j<=coinCount-1;j++){
                coinsArray[j] = coinsInput.next();
            }

            //for each coin in coins array, add to insertcash()
            for (String coinEnum : coinsArray) {
                Cash cash = Cash.valueOf(coinEnum.toUpperCase() );
                vendingMachine.insertCoin(cash);

            }


            // if its paid full, collect item and change
            Store<Product, List<Cash>> productListBucket = vendingMachine.collectItemAndChange();
            System.out.println("Collect item : "+productListBucket.getFirst());
            System.out.println("Collect change : "+productListBucket.getSecond());
            System.out.println("Thank you for shopping");


        }
        // Cancel if 'C' is pressed
        if(choice.equalsIgnoreCase("C")){
            vendingMachine.reset();
            System.out.println("Thanks for coming!!");

        }
    }

    public static boolean valueEntered(String choice){
        if(choice.equalsIgnoreCase("P") || choice.equalsIgnoreCase("C"))
        {
            return true;
        }

        return false;
    }
}
