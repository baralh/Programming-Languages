//Heman Baral
//Assignment 7


public class FoodBankPatrons {

    public static void main(String... args){
        FoodBank bank = new FoodBank();
        FoodProducer foodProducer = new FoodProducer(bank);
        FoodConsumer foodConsumer = new FoodConsumer(bank);
        foodProducer.start();
        foodConsumer.start();
    }
}
