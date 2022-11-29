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

        darkside.addWarlock(1);
        darkside.addSharpshooter(1);
        //darkside.addPeasant(3);
        darkside.addRogue(1);

        //ligthside.addPeasant(1);
        ligthside.addMonk(1);
        ligthside.addLancer(1);
        ligthside.addCrossbownman(1);

        while (true){
            Scanner sc = new Scanner(System.in);
            ConsoleView.view();
            Turn.Turn();
            sc.nextLine();
        }


    }
}



