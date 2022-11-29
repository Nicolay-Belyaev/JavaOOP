package utils;

import classes.*;
import main.main;

public class Turn {
    public static void Turn() {

        //region melee
        for (BaseHero character : main.darkside
                .getHeroesByClass("rogue")
                .getAliveHeroes()) {
            character.step(main.ligthside);
        }
        for (BaseHero character : main.ligthside
                .getHeroesByClass("lancer")
                .getAliveHeroes()) {
            character.step(main.darkside);
        }
        //endregion

        //region RDD
        for (BaseHero character : main.darkside
                .getHeroesByClass("sharpshooter")
                .getAliveHeroes()) {
            character.step(main.ligthside);
        }
        for (BaseHero character : main.ligthside
                .getHeroesByClass("xbowman")
                .getAliveHeroes()) {
            character.step(main.darkside);
        }
        //endregion

        //region Support
        for (BaseHero character : main.darkside
                .getHeroesByClass("warlock")
                .getAliveHeroes()) {
            character.step(main.ligthside);
        }
        for (BaseHero character : main.ligthside
                .getHeroesByClass("monk")
                .getAliveHeroes()) {
            character.step(main.darkside);
        }
        //endregion

        //region Peasants
        for (BaseHero character : main.darkside
                .getHeroesByClass("peasant")
                .getAliveHeroes()) {
            character.step(main.ligthside);
        }

        for (BaseHero character : main.ligthside
                .getHeroesByClass("peasant")
                .getAliveHeroes()) {
            character.step(main.darkside);
        }
        //endregion


    }
}
