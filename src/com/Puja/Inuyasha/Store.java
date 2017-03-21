package com.Puja.Inuyasha;

/**
 * Created by Puja on 3/20/17.
 */
public class Store<E1, E2> {
    private E1 first;
    private E2 second;

    public Store(E1 first, E2 second){
        this.first = first;
        this.second = second;
    }

    public E1 getFirst(){
        return first;
    }

    public E2 getSecond(){
        return second; }
}


