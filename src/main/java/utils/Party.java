package utils;

import classes.*;
import main.main;

import java.util.ArrayList;
import java.util.Random;

public class Party extends ArrayList<BaseHero> {
    public Party() {}

    public Party(Party party1, Party party2) {
        this.addAll(party1);
        this.addAll(party2);
    }

    public Party(int partySize) {
        Random rand = new Random();
        for (int i = 0; i < partySize; i++) {
            int charSelector = rand.nextInt(0, 7);
            switch (charSelector) {
                case 0 -> this.addPeasant(1);
                case 1 -> this.addRogue(1);
                case 2 -> this.addSharpshooter(1);
                case 3 -> this.addLancer(1);
                case 4 -> this.addWarlock(1);
                case 5 -> this.addMonk(1);
                case 6 -> this.addCrossbownman(1);
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

    public Party getAliveHeroes() {
        Party aliveHeroes = new Party();
        for (BaseHero character : this) {
            if (!character.getStatus().equals("dead")) {
                aliveHeroes.add(character);
            }
        }
        return aliveHeroes;
    }

    public Party getDeadHeroes() {
        Party deadHeroes = new Party();
        for (BaseHero character : this) {
            if (character.getStatus().equals("dead")) {
                deadHeroes.add(character);
            }
        }
        return deadHeroes;
    }

    public Party getHeroesByClass(String heroClass) {
        Party oneClassHeroes = new Party();
        for (BaseHero character : this) {
            if (character.getClassName().equals(heroClass)) {
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
            this.add(new Xbowman(this, x, y));
        }
    }

    //endregion
}
