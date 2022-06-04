package javacore.beginner_tip;


import java.util.concurrent.Semaphore;

public class TipThree {

    /**
     * 교착상태(deadlock) 강제 유발
     */

    static final int num = 5; // number of philosphers & chopsticks

    public static void main(String[] args) {
        int i;
        /* chopsticks */
        Semaphore[] stick = new Semaphore[num];
        for (i=0; i<num; i++)
            stick[i] = new Semaphore(1);
        /* philosophers */
        Philosopher[] phil = new Philosopher[num];
        for (i=0; i<num; i++)
            phil[i] = new Philosopher(i, stick[i], stick[(i+1)%num]);
        /* let philosophers eat and think */
        for (i=0; i<num; i++)
            phil[i].start();
    }
}

class Philosopher extends Thread {
    int id; // philosopher id
    Semaphore lstick, rstick; // left, right chopsticks
    Philosopher(int id, Semaphore lstick, Semaphore rstick) {
        this.id = id;
        this.lstick = lstick;
        this.rstick = rstick;
    }

    public void run() {
        try {
            while (true) {
                lstick.acquire();
                rstick.acquire();
                eating();
                lstick.release();
                rstick.release();
                thinking();
            }
        }catch (InterruptedException e) { }
    }

    void eating() {
        System.out.println("[" + id + "] eating");
    }

    void thinking() {
        System.out.println("[" + id + "] thinking");
    }
}