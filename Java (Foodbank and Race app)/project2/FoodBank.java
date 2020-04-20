//Heman Baral
//Assignment 7


import java.util.concurrent.locks.ReentrantLock;

public class FoodBank {


    ReentrantLock lock = new ReentrantLock();

    public int food;

    public FoodBank() {
        this.food = 0;
    }

    public void giveFood( int amount){

        lock.lock();
        try{
            this.food += amount;
        } finally {
            lock.unlock();
        }
    }

    public void takeFood(int amount){

        lock.lock();
        try{
            this.food -= amount;
        } finally {
            lock.unlock();
        }
    }
}
