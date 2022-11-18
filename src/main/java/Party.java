import java.util.ArrayList;
import java.util.Random;

public class Party {
    private int partySize;
    private ArrayList<BaseHero> party;

     /**
     * Создает группу заданного размера и наполняет её персонажами (классы выбираются случайно).
     * @param partySize - размер группы.
     */
    public Party (int partySize) {
        this.partySize = partySize;
        this.party = new ArrayList<>();
        Random rand = new Random();
        int charCounter = 0;
        while (charCounter < partySize) {
            int charSelectror = rand.nextInt(0, 7);
            switch (charSelectror) {
                case 0 -> party.add(new Peasant());
                case 1 -> party.add(new Rogue());
                case 2 -> party.add(new Sharpshooter());
                case 3 -> party.add(new SpearMan());
                case 4 -> party.add(new Warlock());
                case 5 -> party.add(new Monk());
                case 6 -> party.add(new CrossBowman());
            }
            charCounter++;
        }
    }

    /**
     *
     */
    public Party() {
        this.party = new ArrayList<>();
    }
}
