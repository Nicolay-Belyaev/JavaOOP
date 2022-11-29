package utils;

import classes.CharsCoords;
import main.main;

import java.util.Collections;

public class ConsoleView {
    private static final int darksideSize = main.darkside.size();
    private static final int ligthsideSize = main.ligthside.size();
    private static final String top = "              " + "Darkside:" + "              " +
                                      "\u250c" +
                                      String.join("", Collections.nCopies(main.fieldSize-1, "\u2500\u252c")) +
                                      "\u2500\u2510" +
                                      "              " + "Ligthside:" + "              ";
    private static final String mid = "                            " +
                                      String.join("", Collections.nCopies(9, " ")) +
                                      "\u251c" +
                                      String.join("", Collections.nCopies(main.fieldSize-1, "\u2500\u253c")) +
                                      "\u2500\u2524";
    private static final String bot = "                                     " +
                                      "\u2514" +
                                      String.join("", Collections.nCopies(main.fieldSize-1, "\u2500\u2534")) +
                                      "\u2500\u2518";

    public static void view() {
        System.out.println(top);
        for (int i = 0; i < main.fieldSize; i++) {
            //region Собираем строчку
            StringBuilder currentCharInfo = new StringBuilder("                                     ");
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
            //endregion
            if (i < main.fieldSize - 1) {
                System.out.println(mid);
            }
        }
        System.out.println(bot);
    }

    private static String getChar(CharsCoords position) {
        String str = "| ";
        for (int i = 0; i < darksideSize; i++) {
            if (main.darkside.get(i).getCoords().equals(position)) {
                str = "|" + Colors.RED + main.darkside.get(i).getClassName().toUpperCase().charAt(0) + Colors.RESET;
            }
        }
            for (int i = 0; i < ligthsideSize; i++) {
            if (main.ligthside.get(i).getCoords().equals(position)){
                str = "|" + Colors.BLUE + main.ligthside.get(i).getClassName().toUpperCase().charAt(0) + Colors.RESET;
            }
        }
        return str;
    }
}
