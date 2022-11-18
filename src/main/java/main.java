import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        ArrayList<BaseHero> party = new ArrayList<>();

        party.add(new Peasant());
        party.add(new Rogue());
        party.add(new Sharpshooter());
        party.add(new Warlock());
        party.add(new CrossBowman());
        party.add(new SpearMan());
        party.add(new Monk());

        party.forEach(System.out::println);

        ArrayList<BaseHero> army = new ArrayList<>();

        Random rand = new Random();

    }
}
