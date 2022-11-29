package classes;

import utils.Party;

public class Warlock extends BaseHero {

    public Warlock(Party side, int x, int y) {
        super(17, 12, 30, 9, -5, -5, "warlock","alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
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