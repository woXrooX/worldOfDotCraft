package WDC;

import java.util.HashMap;

class Hero{
  private static String name = "Name";
  private static double level = Conf.HERO_INIT_LVL;
  private static int HP = Conf.HERO_INIT_HP;
  private static int MP = Conf.HERO_INIT_MP;
  private static int GP = Conf.HERO_INIT_GP;
  private static int x = Conf.MAP_WIDTH/2;
  private static int y = Conf.MAP_HEIGHT/2;
  private static int pX = Hero.x;
  private static int pY = Hero.y;
  private static int enemiesKilled = 0;
  private static boolean isBOFActive = false;
  private static int movementSpeed = Conf.HERO_INIT_MOVEMENT_SPEED;
  private static boolean isBossHasBeenKilled = false;

  private static HashMap<String, String> slots = new HashMap<String, String>();

  public static void setName(String name){Hero.name = name;}
  public static void setX(int x){
    Hero.pX = Hero.x;
    Hero.x = x;
  }
  public static void setY(int y){
    Hero.pY = Hero.y;
    Hero.y = y;
  }
  public static void setHP(int HP){Hero.HP = HP;}
  public static void setMP(int MP){Hero.MP = MP;}
  public static void setGP(int GP){Hero.GP = GP;}
  public static void setLVL(double level){Hero.level = level;}
  public static void setEK(int EK){Hero.enemiesKilled = EK;}
  public static void setSlots(String key, String value){Hero.slots.put(key, value);}
  public static void setIsBossHasBeenKilled(boolean bool){Hero.isBossHasBeenKilled = bool;}

  public static String getName(){return Hero.name;}
  public static int getX(){return Hero.x;}
  public static int getY(){return Hero.y;}
  public static int getPX(){return Hero.pX;}
  public static int getPY(){return Hero.pY;}
  public static int getHP(){return Hero.HP;}
  public static int getMP(){return Hero.MP;}
  public static int getGP(){return Hero.GP;}
  public static double getLVL(){return Hero.level;}
  public static int getEK(){return Hero.enemiesKilled;}
  public static HashMap getSlots(){return Hero.slots;}
  public static boolean getIsBOFActive(){return Hero.isBOFActive;}
  public static int getMovementSpeed(){return Hero.movementSpeed;}
  public static boolean getIsBossHasBeenKilled(){return Hero.isBossHasBeenKilled;}

  public static void toggleBOF(){
    Hero.isBOFActive = Hero.isBOFActive?false:true;
    Hero.movementSpeed = Hero.isBOFActive?Conf.BOF_SPEED:Conf.HERO_INIT_MOVEMENT_SPEED;
  }

  public static void info(){
    String items = "| ";
    if(slots.size() > 0){
      for(String slot:slots.values()){
        items +=slot+" | ";
      }
    }else{
      items = "No items yet!";
    }

    System.out.println(
      "\nLevel: "+level+
      "\tName: "+name+
      "\nHealth: "+HP+
      "\tGold: "+GP+
      "\nMana: "+MP+
      "\nEnemies Killed: "+enemiesKilled+
      "\nSlots: "+items
    );
  }
}
