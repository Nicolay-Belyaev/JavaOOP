import Classes.*;

public class main {
    public static void main(String[] args) {
        Party darkside = new Party();
        Party ligthside = new Party();

        darkside.add(new Warlock(darkside));
        darkside.addPeasant(2);
        darkside.addRogue(4);
        darkside.addSharpshooter(3);

        ligthside.add(new Monk(ligthside));
        ligthside.addPeasant(2);
        ligthside.addSpearman(4);
        ligthside.addCrossbownman(3);


        System.out.println(darkside);

        for (BaseHero character : darkside) {
            character.setCurrentHp(character.getCurrentHp() - 1); // все получили божественного чапалаха.
            character.CheckStatus(); // и не все его переживут.
        }

        darkside.get(9).setCurrentHp(5);
        System.out.println(darkside);
        darkside.get(0).Step(darkside);
        System.out.println(darkside);
    }
}

