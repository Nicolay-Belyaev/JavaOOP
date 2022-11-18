public class main {
    public static void main(String[] args) {
        Party party = new Party();
        party.addWarlock(1);
        party.addMonk(1);
        party.addSharpshooter(1);
        party.addRogue(1);
        party.addSpearman(1);
        party.addPeasant(1);
        party.addCrossbownman(1);


        Party party1 = new Party(50);
        Party.getHeroesByClass("warlock", party1);
    }
}

