import Classes.*;

import java.util.ArrayList;

public class Party extends ArrayList<BaseHero> {
    public Party() {}
//    public Party(int partySize) {
//        Random rand = new Random();
//        for (int i = 0; i < partySize; i++) {
//            int charSelector = rand.nextInt(0, 7);
//            switch (charSelector) {
//                case 0 -> this.add(new Peasant(this));
//                case 1 -> this.add(new Rogue(this));
//                case 2 -> this.add(new Sharpshooter(this));
//                case 3 -> this.add(new Spearman(this));
//                case 4 -> this.add(new Warlock(this));
//                case 5 -> this.add(new Monk(this));
//                case 6 -> this.add(new Crossbowman(this));
//            }
//        }
//    }

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
            int x = (this == main.darkside) ? 0 : main.fieldSize-1;
            int y = this.size();
            this.add(new Peasant(this, x, y));
        }
    }
    public void addRogue(int rogues) {
        for (int i = 0; i < rogues; i++) {
            int x = (this == main.darkside) ? 0 : main.fieldSize-1;
            int y = this.size();
            this.add(new Rogue(this, x, y));
        }
    }
    public void addSharpshooter(int sharpshooters) {
        for (int i = 0; i < sharpshooters; i++) {
            int x = (this == main.darkside)? 0 : main.fieldSize-1;
            int y = this.size();
            this.add(new Sharpshooter(this, x, y));
        }
    }
    public void addWarlock(int warlocks) {
        for (int i = 0; i < warlocks; i++) {
            int x = (this == main.darkside) ? 0 : main.fieldSize-1;
            int y = this.size();
            this.add(new Warlock(this, x, y));
        }
    }
    public void addMonk(int monks) {
        for (int i = 0; i < monks; i++) {
            int x = (this == main.darkside) ? 0 : main.fieldSize-1;
            int y = this.size();
            this.add(new Monk(this, x, y));
        }
    }
    public void addLancer(int lancer) {
        for (int i = 0; i < lancer; i++) {
            int x = (this == main.darkside) ? 0 : main.fieldSize-1;
            int y = this.size();
            this.add(new Lancer(this, x, y));
        }
    }
    public void addCrossbownman(int crossbownmans) {
        for (int i = 0; i < crossbownmans; i++) {
            int x = (this == main.darkside) ? 0 : main.fieldSize-1;
            int y = this.size();
            this.add(new Crossbowman(this, x, y));
        }
    }
    //endregion
}
