public class main {
    public static void main(String[] args) {
        Party darkside = new Party();
        Party ligthside = new Party();

        darkside.addWarlock(1);
        darkside.addPeasant(2);
        darkside.addRogue(4);
        darkside.addSharpshooter(3);

        ligthside.addMonk(1);
        ligthside.addPeasant(2);
        ligthside.addSpearman(4);
        ligthside.addCrossbownman(3);

        System.out.println(Party.getHeroesByClass("peasant", darkside));
        System.out.println(Party.getHeroesByClass("spearman", ligthside));
    }
}

