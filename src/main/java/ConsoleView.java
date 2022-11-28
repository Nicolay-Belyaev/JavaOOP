import Classes.CharsCoords;
import java.util.Collections;

public class ConsoleView {
    private static final String top = "\u250c" + String.join("", Collections.nCopies(9, "\u2500\u252c")) + "\u2500\u2510";
    private static final String mid = "\u251c" + String.join("", Collections.nCopies(9, "\u2500\u253c")) + "\u2500\u2524";
    private static final String bot = "\u2514" + String.join("", Collections.nCopies(9, "\u2500\u2534")) + "\u2500\u2518";

    public static void view() {
        System.out.println(top);
        for (int i = 0; i < main.fieldSize; i++) {
            for (int j = 0; j < main.fieldSize; j++) {
                System.out.print(getChar(new CharsCoords(j, i)));
            }
            System.out.println("|");
            if (i < main.fieldSize - 1) {
                System.out.println(mid);
            }
        }
        System.out.println(bot);
    }

    private static String getChar(CharsCoords position) {
        String str = "| ";
        for (int i = 0; i < main.fieldSize; i++) {
            if (main.darkside.get(i).getCoords().equals(position)){
                str = "|"+main.darkside.get(i).getClassName().toUpperCase().charAt(0);
            };
            if (main.ligthside.get(i).getCoords().equals(position)){
                str = "|"+main.ligthside.get(i).getClassName().toUpperCase().charAt(0);
            };
        }
        return str;
    }
}
