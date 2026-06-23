package com.online.store.model.users;


public abstract class Account {


    protected double balance;



    public Account(){

        balance = 0;

    }




    public void recharge(double amount){


        if(amount <= 0){

            throw new IllegalArgumentException(
                    "Invalid amount"
            );

        }


        balance += amount;

    }




    public void deductBalance(double amount){


        if(balance < amount){

            throw new IllegalStateException(
                    "Insufficient balance"
            );

        }


        balance -= amount;

    }




    public double getBalance(){

        return balance;

    }


}