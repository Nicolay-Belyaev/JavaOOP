import java.util.ArrayList;
import java.util.Collections;

public class main {
    public static void main(String[] args) {
        ArrayList<BaseHero> peasants = new ArrayList<>(5);
        ArrayList<BaseHero> rogues = new ArrayList<>(5);
        ArrayList<BaseHero> sharpshooters = new ArrayList<>(5);
        ArrayList<BaseHero> warlocks = new ArrayList<>(5);
        ArrayList<BaseHero> crossbowmans = new ArrayList<>(5);
        ArrayList<BaseHero> spearmans = new ArrayList<>(5);
        ArrayList<BaseHero> monks = new ArrayList<>(5);

        for (int i = 0; i < 5; i++) {
            peasants.add(new Peasant());
            rogues.add(new Rogue());
            sharpshooters.add(new Sharpshooter());
            warlocks.add((new Warlock()));
            crossbowmans.add(new CrossBowman());
            spearmans.add(new SpearMan());
            monks.add(new Monk());
        }

        peasants.forEach(System.out::println);
        System.out.println();
        rogues.forEach(System.out::println);
        System.out.println();
        sharpshooters.forEach(System.out::println);
        System.out.println();
        warlocks.forEach(System.out::println);
        System.out.println();
        crossbowmans.forEach(System.out::println);
        System.out.println();
        spearmans.forEach(System.out::println);
        System.out.println();
        monks.forEach(System.out::println);
    }
}
