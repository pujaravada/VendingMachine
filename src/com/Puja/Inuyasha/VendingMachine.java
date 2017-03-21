package com.Puja.Inuyasha;

import java.util.List;

/**
 * Created by Puja on 3/21/17.
 */
public interface VendingMachine
{
    public long selectItemAndGetPrice(Product item);
    public void insertCoin(Cash coin);
    public Store<Product, List<Cash>> collectItemAndChange();
    public void reset();
}

