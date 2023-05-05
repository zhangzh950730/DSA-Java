package com.zzh.demo;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class BankAccount {
    private AtomicReference<BigDecimal> balance;

    public BankAccount(BigDecimal balance) {
        this.balance = new AtomicReference<>(balance);
    }

    public void deposit(BigDecimal amount) {
        BigDecimal oldValue, newValue;
        do {
            oldValue = balance.get();
            newValue = oldValue.add(amount);
        } while (!balance.compareAndSet(oldValue, newValue));
    }

    public BigDecimal getBalance() {
        return balance.get();
    }
}

class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(BigDecimal.ZERO);
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    account.deposit(BigDecimal.ONE);
                }
            }).start();
        }
        System.out.println("Final balance: " + account.getBalance());
    }
}

