package classes;

import utils.Party;

public class Warlock extends BaseHero {

    public Warlock(Party side, int x, int y, int amount) {
        super(17, 12, 30, 9, -5, -5, 1,"Warlock","alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
        super.amount = amount;
    }


    // 1. лечение
    // 2. воскрешение с 1 hp
    // 3. некого лечить и воскрешать - чистым уроном прописать чапалах противнику.
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