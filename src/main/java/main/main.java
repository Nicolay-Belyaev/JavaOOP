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
        darkside.addRogue(4,1);
        darkside.addRogue(1, 10);
        lightside.addLancer(5,1);
        lightside.addLancer(1,12);


        while (true){
            Scanner sc = new Scanner(System.in);
            ConsoleView.view();
            Turn.Turn();
            sc.nextLine();
        }
    }
}



