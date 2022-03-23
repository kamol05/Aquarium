package acvarium;

import lombok.Getter;

@Getter
public class Fish extends Thread {
    private static int counts = 0;
    private int lifeTime;
    private boolean sex;

    @Override
    public void run() {
        while (lifeTime > 0){
            try {
                Thread.sleep(1000);
                lifeTime -= 1000;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Aquarium.fishList.remove(this);
        Log.info(Thread.currentThread().getName() + " is dead!" );
    }
    public Fish() {
        super("FISH " + counts++);
        super.setDaemon(true);
    }
    public Fish(String name) {
        super(name + counts++);
        super.setDaemon(true);
    }
    public static Fish getMale(){
        Fish fish = new Fish();
        fish.lifeTime = Settings.LIFETIME();
        fish.sex = true;
        return fish;
    }
    public static Fish getFemale(){
        Fish fish = new Fish();
        fish.lifeTime = Settings.LIFETIME();
        fish.sex = false;
        return fish;
    }
    public static Fish getBaby(String name){
        Fish fish = new Fish(name);
        fish.lifeTime = Settings.LIFETIME();
        fish.sex = Settings.SEX();
        return fish;
    }

    @Override
    public String toString() {
        return "Fish{" +
                ", lifeTime=" + lifeTime +
                ", sex=" + (sex ? "MALE" : "FEMALE")  +
                '}';
    }


}
