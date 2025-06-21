// Рефлексия 1.3
// Явно не прописывал видимость методов.

// 5.1. - 5.3. :

    class Character {
        private String name;
        private double health;
        private Weapon currentWeapon;

        Character(String n, double h){
          this.name = n;
          this.health = h;
        }

        public void getDamage(double damage) {
          this.health -= damage;
          if (this.health < 0) {
            this.health = 0;
          }
        }

        public void takePills(double pills) {
          this.health += pills;
        }

        public void setWeapon(Weapon wp) {
            this.currentWeapon = wp;
        }
    }

    class Worm extends Character{
      private double speed;
      private double protection;
      private double jump;

      Worm(String n, double h, double s, double p, double j){
        super(n, h);
        this.setSpeed(s);
        this.protection = p;
        this.jump = j;
      }

      public void setSpeed(double s){
        this.speed = s;
      }

    }

    class Weapon {
      private String name;
      private double damage;
      private double range;
      private double spread;

      Weapon(String n, double d, double r, double s,){
        this.name = n;
        this.damage = d;
        this.range = r;
        this.spread = s;
      }

      public void changeSpread(double val) {
        this.spread += val;
      }
    }

    class Item { 
      private int left;
      private int top; 
      private String img; 

      Item(int l, int t){
        this.left = l;
        this.top = t;
      }

      public void changePosition(int l, int t) {
        this.left = l;
        this.top = t;
      }
    }

    class Map {
      private int width;
      private int height;
      private Item[] items;

      Map(int w, int h) {
        this.width = w;
        this.height = h;
      }
    }

// Исправление

    class Weapon {
      private String name;
      private double damage;
      private double range;
      private double spread;
      private double canDamageSeveralUnits;

      Weapon(String n, double d, double r, double s){
        this.name = n;
        this.damage = d;
        this.range = r;
        this.spread = s;
        this.canDamageSeveralUnits = false;
      }
    }

    class Mine extends Weapon{
      private boolean detonated;

      Mine() {
        super("Mine", 40.0, 0.0, 0.0); // range равен 0, так как мину можно кинуть только перед собой
        this.detonated = false;
        this.canDamageSeveralUnits = true;
      }

      isDetonate(){
        return this.detonated;
      }

      detonate(){
        this.detonated = true;
      }
    }

    class Gun extends Weapon {
      Gun() {
        super("Gun", 70.0, 40.0, 30.0);
      }

      public void changeSpread(double val) { // изменение разброса с помощью глушителя
        this.spread += val;
      }
    }

    class Grenade extends Weapon {
      Grenade() {
        super("Grenade", 100.0, 20.0, 50.0);
        this.canDamageSeveralUnits = true;
      }
    }

    class Unit {
      private String name;
      private double health;
      private Weapon currentWeapon;
      private int jump; // кол-во пикселей
      private int protection;
      private int speed; // км / ч

      Unit(String n, double h, int j, int s, int p){
        this.name = n;
        this.health = h;
        this.jump = j;
        this.speed = s;
        this.protection = p;
      }

      public void getDamage(double damage) {
        this.health -= damage;
        if (this.health < 0) {
          this.health = 0;
        }
      }  
      public void takePills(double pills) {
        this.health += pills;
      }  
      public void setWeapon(Weapon wp) {
          this.currentWeapon = wp;
      }
    }

    class Worm extends Unit {
      Worm(){
        super("Worm", 100.0, 10, 1, 0)
      }
    }

    class Dog extends Unit { 
      Dog(){
        super("Dog", 100.0, 20, 30, 40)
      }
    }

    class Rabbit extends Unit { 
      Rabbit(){
        super("Rabbit", 100.0, 15, 40, 20)
      }

      doubleJump(){
        // Двойной прыжок на карте
      }
    }
