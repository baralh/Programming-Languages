//Heman Baral
//Assignment 7



import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class FoodProducer extends Thread {

    private FoodBank bank;

    public FoodProducer(FoodBank bank) {
        this.bank = bank;
    }

    public void run(){
        while(true){
            Random rand = new Random();
            int amount = rand.nextInt(100) + 1;
            bank.giveFood(amount);
            System.out.println("Given "+ amount +" items of food, the balance is now "+ bank.food +" items ");
            try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}

        }
    }


}
