public class Peasant extends  BaseHero {
    private int deliviry;

    public Peasant (int offence, int defence, int hp, int speed, int deliviry, String name) {
        this.offence = offence;
        this.defence = defence;
        this.hp = hp;
        this.speed = speed;
        this.deliviry = deliviry;
        this.name = name;
    }
    public Peasant (String name) {
        this.offence = 1;
        this.defence = 1;
        this.hp = 1;
        this.speed = 3;
        this.deliviry = 1;
        this.name = name;
    }
    public Peasant() {}
}
