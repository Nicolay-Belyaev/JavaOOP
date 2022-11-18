import java.util.ArrayList;
import java.util.Random;

public class Party {
    private int partySize;
    private ArrayList<BaseHero> group = new ArrayList<>(partySize);

    public Party() {}

     /**
     * Создает группу заданного размера и наполняет её персонажами (классы выбираются случайно).
     * @param partySize размер группы.
     */
    public Party(int partySize) {
        this.partySize = partySize;
        Random rand = new Random();
        for (int i = 0; i < partySize; i++) {
            // TODO: вопрос. а если классов 20, 120? как делают белые люди?
            int charSelector = rand.nextInt(0, 7);
            switch (charSelector) {
                case 0 -> group.add(new Peasant());
                case 1 -> group.add(new Rogue());
                case 2 -> group.add(new Sharpshooter());
                case 3 -> group.add(new Spearman());
                case 4 -> group.add(new Warlock());
                case 5 -> group.add(new Monk());
                case 6 -> group.add(new Crossbowman());
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder resString = new StringBuilder();
        for (BaseHero character : group) {
            resString.append(character.toString())
                     .append("\n");
        }
        return resString.toString();
    }

    /**
     * Показывает всех персонажей определенного класса, состоящих в группе.
     * @param heroClass String, название класса.
     * @param party Party, группа в которой ищем персонажей заданного класса.
    */
    // TODO: вопрос. можно было бы не страдать, и дернуть класс через getClass(), пришлось бы немного поработать
    // TODO: с возвратом (там строка вида "Class |X|"). Но я решил, что так будет лучше. Вопрос - как все же лучше?
    public static void getHeroesByClass(String heroClass, Party party) {
        for (BaseHero character : party.getGroup()) {
            if (character.className.equals(heroClass.toLowerCase())) {
                System.out.println(character);
            }
        }
    }

    public ArrayList<BaseHero> getGroup() {return group;}

    // TODO: вопрос. тут, наверное, можно было использовать паттерн Builder. Но как я не крутил, у меня вышло.
    // TODO: хотелось бы узнать, можно ли это сделать и как. И надо ли вот тут вообще.
    //region методы для добавления персонажей в группу
    public void addPeasant(int peasants) {
        for (int i = 0; i < peasants; i++) {
            group.add(new Peasant());
        }
    }
    public void addRogue(int rogues) {
        for (int i = 0; i < rogues; i++) {
            group.add(new Rogue());
        }
    }
    public void addSharpshooter(int sharpshooters) {
        for (int i = 0; i < sharpshooters; i++) {
            group.add(new Sharpshooter());
        }
    }
    public void addWarlock(int warlocks) {
        for (int i = 0; i < warlocks; i++) {
            group.add(new Warlock());
        }
    }
    public void addMonk(int monks) {
        for (int i = 0; i < monks; i++) {
            group.add(new Monk());
        }
    }
    public void addSpearman(int spearmans) {
        for (int i = 0; i < spearmans; i++) {
            group.add(new Spearman());
        }
    }
    public void addCrossbownman(int crossbownmans) {
        for (int i = 0; i < crossbownmans; i++) {
            group.add(new Crossbowman());
        }
    }
    //endregion

}
