package javacore.beginner_tip;

import java.util.concurrent.Semaphore;

/**
 * mutex, Semaphore 개념
 *
 * Mutex: 여러 Thread를 사용하는 환경에서 자원에 대한 접근을 강제하기 위한 동기화 매커니즘이다.
 * 공유 자원을 사용 중인 Thread가 있을 때, 다른 Thread가 공유 자원에 접근한다면 Blocking 후 대기 큐로 보낸다.
 * Lock을 걸은 Thread만 Lock을 해제할 수 있다.
 *
 *
 *  세마포는 일반적으로 Mutual exclusion을 위해 사용된다.
 */


public class TipTwo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount b = new BankAccount();
        Parent p = new Parent(b);
        Child c = new Child(b);
        p.start();   // start(): 쓰레드를 실행하는 메서드
        c.start();
        p.join();    // join(): 쓰레드가 끝나기를 기다리는 메서드
        c.join();
        System.out.println("balance = " + b.getBalance());
    }

}



// 계좌
class BankAccount {
    int balance;

    Semaphore sem, semDeposit,semWithDraw;

    public BankAccount() {
        this.sem = new Semaphore(1);
        this.semDeposit = new Semaphore(0);   // Ordeing을 위한 세마포
        this.semWithDraw = new Semaphore(0);
    }

    void deposit(int amount) {

        try {
            sem.acquire();
            int temp = balance + amount;
            System.out.print("+");
            balance = temp;

            sem.release();
            semWithDraw.release();
            semDeposit.release();   // block된 출금 프로세스가 있다면 깨워준다.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 임계구역


    }
    void withdraw(int amount) {
        try {
            semDeposit.acquire(); // 출금을 먼저하려고 하면 block한다.

            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 임계구역

        int temp = balance - amount;
        System.out.print("-");
        balance = temp;

        sem.release();
        semDeposit.release();
    }
    int getBalance() {
        return balance;
    }
}

// 입금 프로세스
class Parent extends Thread {
    BankAccount b;
    Parent(BankAccount b) {
        this.b = b;
    }
    public void run() {   // run(): 쓰레드가 실제로 동작하는 부분(치환)
        for (int i = 0; i < 100; i++)
            b.deposit(1000);
    }
}

// 출금 프로세스
class Child extends Thread {
    BankAccount b;
    Child(BankAccount b) {
        this.b = b;
    }
    public void run() {
        for (int i = 0; i < 100; i++)
            b.withdraw(1000);
    }
}