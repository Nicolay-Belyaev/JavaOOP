package Classes;
import java.util.ArrayList;

public class Warlock extends BaseHero {

    public Warlock(ArrayList<BaseHero> side) {
        super(17, 12, 30, 9, -5, -5, "warlock","alive");
        super.side = side;
    }

    @Override
    public void Step(ArrayList<BaseHero> foes) {
        BaseHero lowestHpCharacter = side.get(0);
        for (BaseHero character : side) {
            if (character.currentHp < lowestHpCharacter.currentHp && character.status.equals("dead")) {
                lowestHpCharacter = character;
            }
        }
        ActionAttack(lowestHpCharacter);
        if (lowestHpCharacter.currentHp > lowestHpCharacter.maxHp) {
            lowestHpCharacter.currentHp = lowestHpCharacter.maxHp;
        }
    }
}