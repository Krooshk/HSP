// Рефлексия 5.1. - 5.2:
//    Добавил скрытые поля во всех классах, добавил конструкторы, 
//    в конструкторах не добавил явно "public".

// Рефлексия 5.3:
//   Сделал только одно наследование для персонажа. В Character сделал поля приватными, хотя следовало сделать protected. 

// Задание 4.1. 

    class Character { // Персонажи (кот, собака, червяк, заяц, дракон, зомби)
        private String name;
        private double health;

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
    }

    class Dog extends Character { 
      protected double speed;
      protected double protection;
      protected double jump;

      Dog(String n, double h, double s, double p, double j){
        super(n, h);
        this.setSpeed(s);
        this.protection = p;
        this.jump = j;
      }

      public void setSpeed(double s){
        this.speed = s;
      }
    }

    
    class Worm extends Character {
      protected double speed;
      protected double protection;

      Worm(String n, double h, double s, double p){
        super(n, h);
        this.setSpeed(s);
        this.protection = p;
      }

      public void setSpeed(double s){
        this.speed = s;
      }
    }


    class Weapon { // Оружие 
      protected String name;
      protected double damage;
      protected double range;
      protected double spread;

      Weapon(String n, double d, double r, double s){
        this.name = n;
        this.damage = d;
        this.range = r;
        this.spread = s;
      }

      public void changeSpread(double val) {
        this.spread += val;
      }
    }

    class Gun extends Weapon {
        Gun(String n, double d, double r, double s) {
            super(n, d, r, s);
        }
    }

    class Grenade extends Weapon {
        Grenade(String n, double d, double r, double s) {
            super(n, d, r, s);
        }
    }

    class Player { // Текущий игрок
        private Weapon weapon;
        private Character character;
        private String name;

        Player(String n, Weapon w, Character ch) {
            this.name = n;
            this.character = ch;
            this.weapon = w;
        }

        public void setWeapon(Weapon wp) {
            this.weapon = wp;
        }
    }


public class HelloWorld{

     public static void main(String []args){
        Dog dog = new Dog("Barsik", 100, 50, 10, 20);
        Worm worm = new Worm("Bolt", 100, 40, 10);
        Gun gun = new Gun("Ultra3000", 90, 150, 20);
        Grenade grenade = new Grenade("Bomb", 200, 35, 80);
        
        Player tony = new Player("Anton", gun, dog);
        Player alex = new Player("Alex", grenade, worm);
     }
}

// Задание 4.2. 

import java.util.Random;
    class Character {
        private String name;
        private double health;

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

       public void foo(){
           System.out.println("Original");
       }
    }

    class Dog extends Character {
      protected double speed;
      protected double protection;
      protected double jump;

      Dog(String n, double h, double s, double p, double j){
        super(n, h);
        this.setSpeed(s);
        this.protection = p;
        this.jump = j;
      }

      public void setSpeed(double s){
        this.speed = s;
      }

      public void foo(){
          System.out.println("Dog");
      }
    }

    
    class Worm extends Character {
      protected double speed;
      protected double protection;

      Worm(String n, double h, double s, double p){
        super(n, h);
        this.setSpeed(s);
        this.protection = p;
      }

      public void setSpeed(double s){
        this.speed = s;
      }

      public void foo(){
          System.out.println("Worm");
      }
    }


public class HelloWorld{

     public static void main(String []args){
        Character[] arr = new Character[500];
        Random rnd = new Random();

        for (int i = 0; i < 500; i ++) {
           if ( rnd.nextInt(2) == 0) {
              Worm worm = new Worm("Bolt", 100, 40, 10);
              arr[i] = worm;
           } else {
              Dog dog = new Dog("Bars", 100, 40, 10, 20);
              arr[i] = dog;
           }
        }
        
        for (int i = 0; i < 500; i ++) {
           arr[i].foo();
        }
     }
}

// Выводится Worm, Dog. Потому что у каждого экземпляра свой метод foo.

// Задание 4.3:

class Example {
    void show(String a){
        System.out.println("String " + a);
    }
    
    void show(int a){
        System.out.println("Int " + a);
    }
}
public class HelloWorld{
     public static void main(String []args){
        Example exemplar = new Example();
        exemplar.show("Hello");
        exemplar.show(5);
     }
}


