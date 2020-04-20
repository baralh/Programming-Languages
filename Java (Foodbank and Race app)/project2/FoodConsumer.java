//Heman Baral
//Assignment 7


import java.util.Random;

public class FoodConsumer extends Thread {

    private FoodBank bank;

    public FoodConsumer(FoodBank bank) {
        this.bank = bank;
    }

    public void run(){
        while(true){

            Random rand = new Random();
            int amount = rand.nextInt(100);
            if(bank.food >= amount){
                bank.takeFood(amount);
                System.out.println("Given "+ amount +" items of food, the balance is now "+ bank.food +" items ");
            } else {
                System.out.println("Waiting to take food");
            }
            try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
        }
    }
}
