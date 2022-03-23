package acvarium;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("Aquarium");
        Log.info("Main thread is started");
        Aquarium aquarium = new Aquarium();
        for (Fish fish : Aquarium.fishList){
            fish.start();
        }
        while (Aquarium.fishList.size() > 0){
            aquarium.reproduction();
            Thread.sleep(5000);
        }

    }
}
