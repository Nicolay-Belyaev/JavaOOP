public class main {
    public static final int fieldSize = 10;
    public static Party darkside = new Party();
    public static Party ligthside = new Party();

    public static void main(String[] args) {

        darkside.addWarlock(5);
        darkside.addPeasant(1);
        darkside.addRogue(1);
        darkside.addWarlock(2);

        ligthside.addMonk(1);
        ligthside.addPeasant(2);
        ligthside.addLancer(4);
        ligthside.addCrossbownman(1);

        ConsoleView.view();

    }
}



