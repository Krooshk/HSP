import java.util.Scanner;
public class ClassInput {
   public static void main(String[] args) {
   Scanner keyboard = new Scanner(System.in);

   int badCode = 171;
   boolean hasProblem = false;

   System.out.println("Routers:");
   int routers = keyboard.nextInt();

   for(int i = 1; i <= routers; i++ ){
       int x = keyboard.nextInt();
       if (x != badCode) continue;
       hasProblem = true;
       System.out.println(i + "-й " + "роутер уязвим.");
       break;
   }
   if (!hasProblem) 
      System.out.println("Уязвимостей не найдено!");
      
   }
}