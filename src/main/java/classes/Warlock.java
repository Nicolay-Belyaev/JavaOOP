package classes;

import utils.Pair;
import utils.Party;

public class Warlock extends BaseHero {

    public Warlock(Party side, int x, int y, int amount) {
        super(17, 12, 30, 9, 5, 5, 1, "Warlock", "alive");
        super.side = side;
        super.coords = new CharsCoords(x, y);
        super.initialAmount = amount;
    }

    private void Attack(Party foes) {
        Pair<BaseHero, Double> closedEnemyAndDistance = getClosedEnemyAndDistance(foes);
        ActionAttack(closedEnemyAndDistance.getKey());
    }

    private void Heal(Party party) {
        BaseHero lowestHpCharacter = party.get(0);
        for (BaseHero character : party) {
            if (character.currentHp < lowestHpCharacter.currentHp) {lowestHpCharacter = character;}
        }
        lowestHpCharacter.getHeal(maxDmg);
    }

    private void Resurrection(Party party) {
        BaseHero lowestAmountCharacter = party.get(0);
        for (BaseHero character : party) {
            if (character.currentAmount < lowestAmountCharacter.currentAmount) {lowestAmountCharacter = character;}
        }
        lowestAmountCharacter.currentAmount += 1;
        lowestAmountCharacter.currentHp = 1;
        lowestAmountCharacter.CheckStatus();
    }

    private void Assist(String className) {
        Party allOneClassHeroes = side.getHeroesByClass(className);
        Party wounded = new Party();
        Party dead = new Party();
        for (BaseHero character : allOneClassHeroes) {
            if (character.currentHp < character.maxHp*0.5) {wounded.add(character);}
            if (character.currentAmount < character.initialAmount) {dead.add(character);}
        }
        if (wounded.size() != 0) {
            Heal(wounded);
        }
        else if (dead.size() != 0) {
            Resurrection(dead);
        }
    }

    @Override
    public void step(Party foes) {
        // ВОПРОС: начальные показатели здоровья не меняются всю игру. хорошо бы не считать их на каждом шагу.
        // как это сделать? Пробовал вынести в поля класса, но там при инициации появляются проблемы.
        // только выносить в main?
        int initialWarlocksHP = side.getInitialClassHp("Warlock");
        int initialSharpshootersHP = side.getInitialClassHp("Sharpshooter");
        int initialRoguesHp = side.getInitialClassHp("Rogue");

        int currentWarlocksHP = side.getCurrentClassHp("Warlock");
        int currentSharpshootersHP = side.getCurrentClassHp("Sharpshooter");
        int currentRoguesHp = side.getCurrentClassHp("Rogue");

        if (currentWarlocksHP < initialWarlocksHP) {
            Assist("Warlock");
        } else if (currentSharpshootersHP < initialSharpshootersHP) {
            Assist("Sharpshooter");
        } else if (currentRoguesHp < initialRoguesHp) {
            Assist("Rogue");
        } else {
            Attack(foes);
        }
    }
}