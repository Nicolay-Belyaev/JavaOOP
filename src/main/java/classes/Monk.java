package classes;

import utils.Party;

public class Monk extends BaseHero {

    public Monk(Party side, int x, int y, int amount) {
        super(12, 7, 30, 5, -4, -4, 1,"Monk", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
        super.initialAmount = amount;
    }

    @Override
    public void step(Party foes) {
        Party aliveAllies = side.getAliveHeroes();
        BaseHero lowestHpCharacter = aliveAllies.get(0);
        for (BaseHero character : aliveAllies) {
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
