public class main {
    public static final int fieldSize = 10;
    public static Party darkside = new Party();
    public static Party ligthside = new Party();

    public static void main(String[] args) {

        darkside.addWarlock(1);
        darkside.addPeasant(2);
        darkside.addRogue(2);
        darkside.addSharpshooter(2);

        ligthside.addMonk(1);
        ligthside.addPeasant(2);
        ligthside.addLancer(1);
        ligthside.addCrossbownman(4);

        ConsoleView.view();

    }
}



