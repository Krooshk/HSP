import java.util.Scanner;
import MyOperation.Summ;
import MyCalculator.Calculator;

public class test {
  public static void main(String[] args){
        Scanner in = new Scanner(System.in); 
        int a = in.nextInt();
        int b = in.nextInt();

        System.out.println(Summ.sum(a, b));
        System.out.println(Calculator.sum(a, b));
        System.out.println(Calculator.sum(a, b) == Summ.sum(a, b)); // true
        System.out.println(Calculator.diff(a, b));
  }
}