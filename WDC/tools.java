package WDC;

import java.io.IOException;

class Tools{

  public static int rand(int min, int max){
    return min+(int)(Math.random()*(max-min+1));
  }

  public static char dialogC(String message){
    System.out.print(message);
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    return scanner.next().charAt(0);
  }
  public static String dialogS(String message){
    System.out.print(message);
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    return scanner.next();
  }

  // windows
  public static void cls() throws IOException, InterruptedException{
    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
  }

  public static void sleep(int duration) throws IOException, InterruptedException{
    Thread.sleep(duration);
  }

  public static void loading() throws IOException, InterruptedException{
    System.out.print("\n");
    for(int i=0;i<100;i++){
      System.out.print("-");
      Thread.sleep(4);
    }
    System.out.print("\n");
  }

  public static void print(String text, String color){
    System.out.print(color+text+Conf.RESET);
  }
}
