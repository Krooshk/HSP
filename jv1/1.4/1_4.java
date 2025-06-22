// Рефлексия 1.3
// Явно не прописывал видимость методов.

// 5.1. - 5.3. :
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
      private boolean isDead;
      private boolean isLand; // персонаж приземлился на землю

      Unit(String n, double h, int j, int s, int p){
        this.name = n;
        this.health = h;
        this.jump = j;
        this.speed = s;
        this.protection = p;
        this.isDead = false;
        this.isLand = true;
      }

      public void getDamage(double damage) {
        this.health -= damage;
        if (this.health < 0) {
          this.health = 0;
          this.isDead = true;
        }
      }

      public void jump() {
        if (this.isLand) {
          setIsLand(false);
          //  calculateJump(this) вызов внешней функции, которая рассчитывает траекторию прыжка, после приземления изменяется флаг isLand с помощью публичного метода setIsLand
        }
      }

      public void setIsLand(boolean value) {
        this.isLand = value;
      }

      public void takePills(double pills) {
        this.health += pills;
      }

      public void setWeapon(Weapon wp) {
          this.currentWeapon = wp;
      }
    }

    // Червяк является самым базовым персонажем, поэтому можно создать экземпляр от класса Unit и не использовать отдельный класс для этого
    class Worm extends Unit {
      Worm(){
        super("Worm", 100.0, 10, 1, 0)
      }
    }

    class Dog extends Unit { 
      Dog(){
        super("Dog", 100.0, 20, 30, 40)
      }

      public void getDamage(double damage) { // От каждой атаки получает только часть урона
        this.health -= damage * 0.8;
        if (this.health < 0) {
          this.health = 0;
          this.isDead = true;
        }
      }
    }

    class Rabbit extends Unit { 
      private int limitJumps; 
      private int currentJumpsLeft;

      Rabbit(){
        super("Rabbit", 100.0, 15, 40, 20)
        this.limitJumps = 2;
      }

      public void jump() {
        if (this.isLand) {
          this.currentJumpsLeft = this.limitJumps;
        }

        if (this.currentJumpsLeft > 0) {
          if (this.currentJumpsLeft == this.limitJumps) {
            setIsLand(false);
          }
          this.currentJumpsLeft--;
          //  calculateJump(this) вызов внешней функции, которая рассчитывает траекторию прыжка, после приземления изменяется флаг isLand с помощью публичного метода setIsLand
        } 
      }
    }
