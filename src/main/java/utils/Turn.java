package utils;

import classes.*;
import main.main;

public class Turn {
    public static void Turn() {

        //region melee
        for (BaseHero character : main.darkside
                .getHeroesByClass("Rogue")
                .getAliveHeroes()) {
            character.step(main.ligthside);
        }
        for (BaseHero character : main.ligthside
                .getHeroesByClass("Lancer")
                .getAliveHeroes()) {
            character.step(main.darkside);
        }
        //endregion

        //region RDD
        for (BaseHero character : main.darkside
                .getHeroesByClass("Sharpshooter")
                .getAliveHeroes()) {
            character.step(main.ligthside);
        }
        for (BaseHero character : main.ligthside
                .getHeroesByClass("Xbowman")
                .getAliveHeroes()) {
            character.step(main.darkside);
        }
        //endregion

        //region Support
        for (BaseHero character : main.darkside
                .getHeroesByClass("Warlock")
                .getAliveHeroes()) {
            character.step(main.ligthside);
        }
        for (BaseHero character : main.ligthside
                .getHeroesByClass("Monk")
                .getAliveHeroes()) {
            character.step(main.darkside);
        }
        //endregion

        //region Peasants
        for (BaseHero character : main.darkside
                .getHeroesByClass("Peasant")
                .getAliveHeroes()) {
            character.step(main.ligthside);
        }

        for (BaseHero character : main.ligthside
                .getHeroesByClass("Peasant")
                .getAliveHeroes()) {
            character.step(main.darkside);
        }
        //endregion


    }
}
