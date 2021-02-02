package WDC;

import java.io.IOException;

class Game{
  protected static Objects health = new Objects(Tools.rand(1, Conf.MAP_WIDTH-2), Tools.rand(1, Conf.MAP_HEIGHT-2), 'H', "You found a "+Conf.GREEN+Conf.H_RUNE_NAME+Conf.RESET+"!\nTo use it enter '+' to leave it enter any key: ");
  protected static Objects mana = new Objects(Tools.rand(1, Conf.MAP_WIDTH-2), Tools.rand(1, Conf.MAP_HEIGHT-2), 'M', "You found a "+Conf.CYAN+Conf.M_RUNE_NAME+Conf.RESET+"!\nTo use it enter '+' to leave it enter any key: ");
  protected static Objects gold = new Objects(Tools.rand(1, Conf.MAP_WIDTH-2), Tools.rand(1, Conf.MAP_HEIGHT-2), 'G', "You found a "+Conf.YELLOW+Conf.G_RUNE_NAME+Conf.RESET+"!\nTo use it enter '+' to leave it enter any key: ");
  protected static Objects enemy = new Objects(Tools.rand(1, Conf.MAP_WIDTH-2), Tools.rand(1, Conf.MAP_HEIGHT-2), 'E', Conf.RED+"Careful!"+Conf.RESET+"\nYou are in enemy's territory\nTo take a fight with enemy enter '+' to runaway enter any key: ");
  protected static Objects surprise = new Objects(Tools.rand(1, Conf.MAP_WIDTH-2), Tools.rand(1, Conf.MAP_HEIGHT-2), 'S', "You found a "+Conf.BLUE+Conf.S_RUNE_NAME+Conf.RESET+"\nTo use it enter '+' to leave it enter any key: ");
  protected static Shop secretShop = new Shop(Tools.rand(1, Conf.MAP_WIDTH-3), Tools.rand(1, Conf.MAP_HEIGHT-3), '$', Conf.RED+"Welcome to Secret Shop"+Conf.RESET);
  protected static Boss roshan = new Boss(Tools.rand(1, Conf.MAP_WIDTH-2-Conf.BOSS_CASTLE_WIDTH), Tools.rand(1, Conf.MAP_HEIGHT-2-Conf.BOSS_CASTLE_HEIGHT), 'R', Conf.RED+"I was w8in 4 u!!!"+Conf.RESET);

  protected static Items[] items = {
    new Items(Conf.BOOTS_OF_SPEED_NAME, Conf.BOF_DESC, Conf.MIN_LVL_TO_UNLOCK_BOF, Conf.BOF_COST, Conf.BOF_SPEED),
    new Items(Conf.HAMMER_NAME, Conf.HAMMER_DESC, Conf.MIN_LVL_TO_UNLOCK_HAMMER, Conf.HAMMER_COST, 0)
  };


  public static void start() throws IOException, InterruptedException{
    intro();
    while(Hero.getHP() > 0 && Hero.getIsBossHasBeenKilled() == false){
      Tools.cls();
      Hero.info();
      World.draw();
      Action.move();
      Action.interact();
    }
    over();
  }
  private static void over() throws IOException, InterruptedException{
    Tools.loading();
    if(Hero.getIsBossHasBeenKilled()){
      Tools.print("\t\tVictory!!!", Conf.GREEN);
    }else{
      Tools.loading();
      Tools.cls();
      Tools.print("\t\tDefeated:-(", Conf.RED);
    }
    Tools.loading();
    Tools.print("\t\tThx 4 attention:)", Conf.CYAN);
    Tools.loading();
    Tools.print("\t\tScore", Conf.RED);
    Hero.info();

  }

  private static void intro() throws IOException, InterruptedException{
    Tools.cls();
    Tools.loading();
    Tools.print(Conf.GAME_NAME, Conf.RED);
    Tools.loading();
    Tools.print(Conf.GAME_RULES, Conf.GREEN);
    Tools.loading();
    Tools.print(Conf.GAME_CONTROLS, Conf.CYAN);
    Tools.loading();
    Hero.setName(Tools.dialogS("Enter hero name: "));
  }
}
