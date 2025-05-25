// Рефлексия 1.2
// Сделал аналогичным образом в контексте другой игры. 

    class Worm {
      String name;
      double speed;
      double protection;
      double jump;
      double health;

      Worm(String n, double s, double p, double j, double h){
        this.name = n;
        this.setSpeed(s);
        this.protection = p;
        this.jump = j;
        this.health = h;
      }

      getDamage(double damage) {
        this.health -= damage;
      }

      takePills(double pills) {
        this.health += pills;
      }
      
      setSpeed(double s){
        this.speed = s;
      }

    }

    class Weapon {
      String name;
      double damage;
      double range;
      double spread;

      Weapon(String n, double d, double r, double s,){
        this.name = n;
        this.damage = d;
        this.range = r;
        this.spread = s;
      }

      changeSpread(double val) {
        this.spread += val;
      }
    }

    class Item { 
      int left;
      int top; 
      String img; 

      Item(int l, int t){
        this.left = l;
        this.top = t;
      }

      changePosition(int l, int t) {
        this.left = l;
        this.top = t;
      }
    }

    class Map {
      int width;
      int height;
      Item[] items;

      Map(int w, int h) {
        this.width = w;
        this.height = h;
      }
    }
