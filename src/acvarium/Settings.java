package acvarium;
import lombok.Getter;
import java.util.Random;

@Getter
public class Settings {
    public static int N(){
        return new Random().nextInt(10) + 1;
    }
    public static int M(){
        return new Random().nextInt(10) + 1;
    }
    public static int LIFETIME(){
        return new Random().nextInt(60_000) + 1;
    }
    public static boolean SEX(){
        return new Random().nextBoolean();
    }
    public static int getCandidate(int size){
        return new Random().nextInt(size);
    }
}
