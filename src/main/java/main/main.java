package main;

import utils.ConsoleView;
import utils.Party;
import utils.Turn;

import java.util.Scanner;

public class main {
    public static final int fieldSize = 10;
    public static Party darkside = new Party();
    public static Party lightside = new Party();

    public static void main(String[] args) {

        darkside.addWarlock(1,1);
        darkside.addRogue(1, 1);

        darkside.addRogue(2, 1);

        lightside.addMonk(1,1);
        lightside.addLancer(2,1);

        lightside.addLancer(2,1);


        while (true){
            Scanner sc = new Scanner(System.in);
            ConsoleView.view();
            Turn.Turn();
            sc.nextLine();
        }
    }
}



