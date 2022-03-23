package acvarium;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
public class Aquarium {
    public static List<Fish> fishList = new CopyOnWriteArrayList<>();

    public Aquarium() {
        Log.info("Start crating Aquarium");
        fillAquarium();
        Log.info("Crating Aquarium is Finished");
    }

    public void fillAquarium(){
        Log.info("Adding Fishes to Aquarium");
        for (int i = 0; i < Settings.N(); i++) {
            fishList.add(Fish.getMale());
        }
        int maleFishSize = fishList.size();
        Log.info(maleFishSize + " Male Fish Added");
        for (int i = 0; i < Settings.M(); i++) {
            fishList.add(Fish.getFemale());
        }
        Log.info((fishList.size() - maleFishSize) + " FeMale Fish Added");
    }

    public void reproduction(){
        Log.info("Begin to Find New Pair");
        Fish fish1 = fishList.get(Settings.getCandidate(fishList.size()));
        Fish fish2 = fishList.get(Settings.getCandidate(fishList.size()));
        if (fish1.isSex() == !fish2.isSex()){
            Log.info("New Pair Of Fishes Finded");
            Fish baby = Fish.getBaby("FISHBABY-");
            fishList.add(baby);
            Log.info("New Baby Fish Added");
            baby.start();
        }
    }

}
