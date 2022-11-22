package Classes;
import java.util.ArrayList;

public class Monk extends BaseHero {

    public Monk(ArrayList<BaseHero> side) {
        super(12, 7, 30, 5, -4, -4, "monk", "alive");
        super.side = side;
    }

    @Override
    public void Step(ArrayList<BaseHero> foes) {
        BaseHero lowestHpCharacter = side.get(0);
        for (BaseHero character : side) {
            if (character.currentHp < lowestHpCharacter.currentHp) {
                lowestHpCharacter = character;
            }
        }
        ActionAttack(lowestHpCharacter);
        if (lowestHpCharacter.currentHp > lowestHpCharacter.maxHp) {
            lowestHpCharacter.currentHp = lowestHpCharacter.maxHp;
        }
    }
}
