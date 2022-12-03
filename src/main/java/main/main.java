package main;

import utils.ConsoleView;
import utils.Party;
import utils.Turn;

import java.util.Scanner;

public class main {
    public static final int fieldSize = 10;
    public static Party darkside = new Party();
    public static Party ligthside = new Party();

    public static void main(String[] args) {


        darkside.addRogue(2);
        darkside.addWarlock(1);
        darkside.addSharpshooter(1);
        darkside.addPeasant(2);

        ligthside.addLancer(2);
        ligthside.addMonk(1);
        ligthside.addPeasant(1);
        ligthside.addLancer(2);
        ligthside.addCrossbownman(2);

        while (true){
            Scanner sc = new Scanner(System.in);
            ConsoleView.view();
            Turn.Turn();
            sc.nextLine();
        }
    }
}



