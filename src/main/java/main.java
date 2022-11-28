import Classes.BaseHero;

public class main {
    public static final int fieldSize = 10;
    public static Party darkside = new Party();
    public static Party ligthside = new Party();

    public static void main(String[] args) {

        darkside.addWarlock(1);
        darkside.addPeasant(2);
        darkside.addRogue(4);
        darkside.addSharpshooter(3);

        ligthside.addMonk(1);
        ligthside.addPeasant(2);
        ligthside.addSpearman(4);
        ligthside.addCrossbownman(3);

        ConsoleView.view();

        for (BaseHero character : darkside) {
            System.out.println(character.getInfo());
        }
        System.out.println();
        for (BaseHero character2 : ligthside) {
            System.out.println(character2.getInfo());
        }
    }
}


