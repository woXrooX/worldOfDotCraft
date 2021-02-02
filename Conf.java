package WDC;

public final class Conf{

  // HP
  public static final String H_RUNE_NAME = "Healing salve";
  public static final int HERO_INIT_HP = 100;
  // public static final int LVL_UP_HP = 200;
  public static final int HP_PER_MOVE = 1;
  public static final int H_RUNE_AMOUNT = 20;
  public static final int HP_COST_TO_FIGHT_ENEMY_IF_ENOUGH_MP = 30;
  public static final int HP_COST_TO_FIGHT_ENEMY_IF_NOT_ENOUGH_MP = 60;
  public static final int HP_COST_TO_RUN_FROM_ENEMY = 60;

  // MP
  public static final String M_RUNE_NAME = "Potion Of Clarity";
  public static final int M_RUNE_AMOUNT = 100;
  public static final int HERO_INIT_MP = 200;
  // public static final int LVL_UP_MP = 200;
  public static final int MP_PER_MOVE = 2;
  public static final int MP_COST_TO_FIGHT_ENEMY = 50;

  // GP
  public static final String G_RUNE_NAME = "Gold";
  public static final int HERO_INIT_GP = 0;
  public static final int G_RUNE_AMOUNT = 5;
  public static final int ENEMY_KILL_BOUNTY = 25;

  // LVL
  public static final double HERO_INIT_LVL = 1.0;
  public static final double ENEMY_KILL_LVL_GAIN = 0.5;

  // Surprise
  public static final String S_RUNE_NAME = "Surprise Box";


  // secretShop
  public static final double MIN_LVL_TO_UNLOCK_SECRET_SHOP = 2.0;
  public static final String BOOTS_OF_SPEED_NAME = "Boots Of Speed";
  public static final String BOF_DESC = "Increases movement speed of wearer (Allows wearer to move "+Conf.BOF_SPEED+" units per move and save MP)";
  public static final double MIN_LVL_TO_UNLOCK_BOF = 2.5;
  public static final int BOF_COST = 100;
  public static final int BOF_SPEED = 3;

  public static final String HAMMER_NAME = "Hammer";
  public static final String HAMMER_DESC = "Used to destroy stones";
  public static final double MIN_LVL_TO_UNLOCK_HAMMER = 3.0;
  public static final int HAMMER_COST = 225;

  // Boss
  public static final double MIN_LVL_TO_UNLOCK_BOSS = 1.5;
  public static final String BOSS_NAME = "Roshan";
  public static final int BOSS_CASTLE_WIDTH = (Conf.BOF_SPEED*2)+1;
  public static final int BOSS_CASTLE_HEIGHT = Conf.BOSS_CASTLE_WIDTH;

  // GAME
  public static final int HERO_INIT_MOVEMENT_SPEED = 1;
  public static final int MAP_HEIGHT = 35; //40
  public static final int MAP_WIDTH = 60; //80
  public static final String GAME_NAME = "WORLD OF DOT CRAFT";
  public static final int INVENTORY_SIZE = 6;


  public static final String GAME_RULES =
    "HOW TO PLAY\n"
      +"\nWALKING\n"
        +"\tWalking around requires you "+Conf.MP_PER_MOVE+" MP per move\n"
        +"\tIf you don't have enough mana then it reduces your health point by "+Conf.HP_PER_MOVE+" per move\n"
      +"\nFIGHTING WITH AN ENEMY\n"
        +"\tYou will spend "+Conf.HP_COST_TO_FIGHT_ENEMY_IF_ENOUGH_MP+" HP and "+Conf.MP_COST_TO_FIGHT_ENEMY+" MP to win a fight with enemies\n"
        +"\tIf you don't have enough mana then you will spend "+Conf.HP_COST_TO_FIGHT_ENEMY_IF_NOT_ENOUGH_MP+" HP to win the fight\n"
        +"\tIf you win a fight with an enemy you will gain "+Conf.ENEMY_KILL_BOUNTY+" gold and "+Conf.ENEMY_KILL_LVL_GAIN+" level\n"
        +"\tIf you come to an enemy's location and runaway it will cost you "+Conf.HP_COST_TO_RUN_FROM_ENEMY+" HP\n"
      // +"\nLEVELS\n"
      //   +"\tEach major level ups give you "+Conf.LVL_UP_HP+" HP and "+Conf.LVL_UP_MP+" MP\n"
      +"\nITEMS\n"
        +"\t1. "+Conf.H_RUNE_NAME+" gives your hero "+Conf.H_RUNE_AMOUNT+" HP\n"
        +"\t2. "+Conf.M_RUNE_NAME+" gives your hero "+Conf.M_RUNE_AMOUNT+" MP\n"
        +"\t3. "+Conf.G_RUNE_NAME+" gives your hero "+Conf.G_RUNE_AMOUNT+" GP\n"
        +"\t4. "+Conf.S_RUNE_NAME+" includes one of these ("+Conf.H_RUNE_NAME+", "+Conf.M_RUNE_NAME+", "+Conf.G_RUNE_NAME+" or Nothing)\n"
        +"\n\t\t\t\tAND DISCOVER MORE INGAME! GLHF:)\n";

  public static final String GAME_CONTROLS =
    "GAME CONTROLS:\n"
    +"\t1: Bottom Left\n"
    +"\t2: Bottom\n"
    +"\t3: Bottom Right\n"
    +"\t4: Left\n"
    +"\t5: Interactions With the World\n"
    +"\t6: Right\n"
    +"\t7: Top Left\n"
    +"\t8: Top\n"
    +"\t9: Top Right\n"
    +"\t+: To interact with objects\n"
    +"\t-----------------\n"
    +"\t0: Exit\n";

  public static final String GAME_OVER = "GAME OVER";

  // from stackoverflow.com :-)
  public static final String RESET = "\u001B[0m";
  public static final String BLACK = "\u001B[30m";
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001b[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String WHITE = "\u001B[37m";
}
