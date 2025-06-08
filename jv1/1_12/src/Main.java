import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Logger log = Logger.getLogger(Logger.class.getName());

        System.out.println("Курс доллара к рублю:");
        int kgSweetsCost = 200; // стоимость кг конфет в рублях
        int oneDollar;
        int amountDollars;

        oneDollar = keyboard.nextInt(); // курс доллара
        log.info("Курс доллара на текущий момент: " + oneDollar);
        amountDollars = keyboard.nextInt(); // всего долларов

        double result = amountDollars * oneDollar * 1.0 / kgSweetsCost;

        assert result >= 0;

        System.out.println(result); // сколько может купить кг конфет покупатель
    }
}



