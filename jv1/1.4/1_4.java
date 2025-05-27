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
