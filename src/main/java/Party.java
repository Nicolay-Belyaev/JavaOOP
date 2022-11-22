import java.util.ArrayList;
import java.util.Random;
import Classes.*;

public class Party extends ArrayList<BaseHero> {
    public Party() {}
    public Party(int partySize) {
        Random rand = new Random();
        for (int i = 0; i < partySize; i++) {
            int charSelector = rand.nextInt(0, 7);
            switch (charSelector) {
                case 0 -> this.add(new Peasant());
                case 1 -> this.add(new Rogue());
                case 2 -> this.add(new Sharpshooter());
                case 3 -> this.add(new Spearman());
                case 4 -> this.add(new Warlock(this));
                case 5 -> this.add(new Monk(this));
                case 6 -> this.add(new Crossbowman());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder resString = new StringBuilder();
        for (BaseHero character : this) {
            resString.append(character.getInfo())
                    .append("\n");
        }
        return resString.toString();
    }

    public static Party getHeroesByClass(String heroClass, Party party) {
        Party oneClassHeroes = new Party();
        for (BaseHero character : party) {
            if (character.getClassName().equals(heroClass.toLowerCase())) {
                oneClassHeroes.add(character);
            }
        }
        return oneClassHeroes;
    }

    //region методы для добавления персонажей в группу
    public void addPeasant(int peasants) {
        for (int i = 0; i < peasants; i++) {
            this.add(new Peasant());
        }
    }
    public void addRogue(int rogues) {
        for (int i = 0; i < rogues; i++) {
            this.add(new Rogue());
        }
    }
    public void addSharpshooter(int sharpshooters) {
        for (int i = 0; i < sharpshooters; i++) {
            this.add(new Sharpshooter());
        }
    }
    public void addWarlock(int warlocks) {
        for (int i = 0; i < warlocks; i++) {
            this.add(new Warlock(this));
        }
    }
    public void addMonk(int monks) {
        for (int i = 0; i < monks; i++) {
            this.add(new Monk(this));
        }
    }
    public void addSpearman(int spearmans) {
        for (int i = 0; i < spearmans; i++) {
            this.add(new Spearman());
        }
    }
    public void addCrossbownman(int crossbownmans) {
        for (int i = 0; i < crossbownmans; i++) {
            this.add(new Crossbowman());
        }
    }
    //endregion
}
