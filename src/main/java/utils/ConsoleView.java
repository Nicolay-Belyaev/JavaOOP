package utils;

import classes.BaseHero;
import classes.CharsCoords;
import main.main;

import java.util.ArrayList;
import java.util.Collections;

public class ConsoleView {
    private static final int darksideSize = main.darkside.size();
    private static final int ligthsideSize = main.ligthside.size();
    private static final String top = String.join("", Collections.nCopies(22, " ")) +
                                      "Darkside:" +
                                      String.join("", Collections.nCopies(14, " "))  +
                                      "\u250c" +
                                      String.join("", Collections.nCopies(main.fieldSize-1, "\u2500\u252c")) +
                                      "\u2500\u2510" +
                                      String.join("", Collections.nCopies(14, " ")) +
                                      "Ligthside:" +
                                      String.join("", Collections.nCopies(14, " "));
    private static final String mid = String.join("", Collections.nCopies(45, " ")) +
                                      "\u251c" +
                                      String.join("", Collections.nCopies(main.fieldSize-1, "\u2500\u253c")) +
                                      "\u2500\u2524";
    private static final String bot = String.join("", Collections.nCopies(45, " ")) +
                                      "\u2514" +
                                      String.join("", Collections.nCopies(main.fieldSize-1, "\u2500\u2534")) +
                                      "\u2500\u2518";

    public static void view() {
        System.out.println(top);
        for (int i = 0; i < main.fieldSize; i++) {
            LineBuilder(i);
            if (i < main.fieldSize - 1) {
                System.out.println(mid);
            }
        }
        System.out.println(bot);
    }

    /**
     * Собирает строку вида: "описание персонажа darkside" + "кусочек поля боя" + "описание персонажа ligthside".
     * Если у одной из сторон персонажи в списке закончились, то
     * для darkside заполняет пространство пробелами,
     * для ligthside оставляет описание пустым.
     */
    private static void LineBuilder(int i) {
        StringBuilder currentCharInfo = new StringBuilder(String.join("",  Collections.nCopies(45, " ")));
        try {
            String infoDarkside = main.darkside.get(i).getInfo();
            currentCharInfo.replace(0, infoDarkside.length(), infoDarkside);
        } catch (IndexOutOfBoundsException ignored) {}

        for (int j = 0; j < main.fieldSize+1; j++) {
            currentCharInfo.append(getChar(new CharsCoords(j, i)));
        }
        try {
            String infoLightside = main.ligthside.get(i).getInfo();
            currentCharInfo.append(" ").append(infoLightside);
        } catch (IndexOutOfBoundsException ignored) {}
        System.out.println(currentCharInfo);
    }

    private static String getChar(CharsCoords position) {

        ArrayList<CharsCoords> darksideCoords = new ArrayList<>();
        for (BaseHero character : main.darkside) {
            darksideCoords.add(character.getCoords());
        }

        String str = "| ";
        for (int i = 0; i < darksideSize; i++) {
            if (main.darkside.get(i).getCoords().equals(position)) {
                if (main.darkside.get(i).getStatus().equals("dead")) {
                    str = "|" + Colors.RED + main.darkside.get(i).getClassName().toUpperCase().charAt(0) + Colors.RESET;
                } else {
                    str = "|" + Colors.GREEN + main.darkside.get(i).getClassName().toUpperCase().charAt(0) + Colors.RESET;
                }

            }
        }
            for (int i = 0; i < ligthsideSize; i++) {
            if (main.ligthside.get(i).getCoords().equals(position)){
                if (main.ligthside.get(i).getStatus().equals("dead")) {
                    str = "|" + Colors.RED + main.ligthside.get(i).getClassName().toUpperCase().charAt(0) + Colors.RESET;
                } else {
                    str = "|" + Colors.BLUE + main.ligthside.get(i).getClassName().toUpperCase().charAt(0) + Colors.RESET;
                }

            }
        }
        return str;
    }
}
