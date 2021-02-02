package WDC;

import java.io.IOException;

class Action extends Game{

  public static void move() throws IOException, InterruptedException{
    String useBOF = Hero.getSlots().get(Conf.BOOTS_OF_SPEED_NAME)!=null?Conf.BOOTS_OF_SPEED_NAME+" is "+(Hero.getIsBOFActive()?"active":"inactive")+" enter 5 to toggle\n":"";
    char action = Tools.dialogC(useBOF+"Enter key to move (or 0 for exit): ");

    if(action == '1' || action == '2' || action == '3' || action == '4' || action == '6' || action == '7' || action == '8' || action == '9'){
      if(Hero.getMP() > 0){
        Hero.setMP(Hero.getMP()-Conf.MP_PER_MOVE);
      }else{
        Hero.setHP(Hero.getHP()-Conf.HP_PER_MOVE);
      }
    }

    if(action == '5' && Hero.getSlots().get(Conf.BOOTS_OF_SPEED_NAME)!=null){
      Hero.toggleBOF();
    }

    switch(action){
      case '1'-> {
        Hero.setX(Hero.getX()-Hero.getMovementSpeed());
        Hero.setY(Hero.getY()+Hero.getMovementSpeed());
      }
      case '2'-> {
        Hero.setY(Hero.getY()+Hero.getMovementSpeed());
      }
      case '3'-> {
        Hero.setX(Hero.getX()+Hero.getMovementSpeed());
        Hero.setY(Hero.getY()+Hero.getMovementSpeed());
      }
      case '4'-> {
        Hero.setX(Hero.getX()-Hero.getMovementSpeed());
      }
      case '6'-> {
        Hero.setX(Hero.getX()+Hero.getMovementSpeed());
      }
      case '7'-> {
        Hero.setX(Hero.getX()-Hero.getMovementSpeed());
        Hero.setY(Hero.getY()-Hero.getMovementSpeed());
      }
      case '8'-> {
        Hero.setY(Hero.getY()-Hero.getMovementSpeed());
      }
      case '9'-> {
        Hero.setX(Hero.getX()+Hero.getMovementSpeed());
        Hero.setY(Hero.getY()-Hero.getMovementSpeed());
      }
      case '0'->{
        Tools.cls();
        System.exit(0);
      }
      default -> System.out.println("Wrong input");
    }
  }

  public static void interact() throws IOException, InterruptedException{
    // health
    if(Hero.getX() == health.getX() && Hero.getY() == health.getY() && Tools.dialogC(health.getMessage()) == '+'){
      Hero.setHP(Hero.getHP()+Conf.H_RUNE_AMOUNT);
      Objects.regenerate(health);
    }

    // mana
    if(Hero.getX() == mana.getX() && Hero.getY() == mana.getY() && Tools.dialogC(mana.getMessage()) == '+'){
      Hero.setMP(Hero.getMP()+Conf.M_RUNE_AMOUNT);
      Objects.regenerate(mana);
    }

    // gold
    if(Hero.getX() == gold.getX() && Hero.getY() == gold.getY() && Tools.dialogC(gold.getMessage()) == '+'){
      Hero.setGP(Hero.getGP()+Conf.G_RUNE_AMOUNT);
      Objects.regenerate(gold);
    }

    // enemy
    if(Hero.getX() == enemy.getX() && Hero.getY() == enemy.getY()){
      if(Tools.dialogC(enemy.getMessage()) == '+'){
        if(Hero.getHP() > Conf.HP_COST_TO_FIGHT_ENEMY_IF_ENOUGH_MP && Hero.getMP() >= Conf.MP_COST_TO_FIGHT_ENEMY){
          Hero.setLVL(Hero.getLVL()+Conf.ENEMY_KILL_LVL_GAIN);
          Hero.setHP(Hero.getHP()-Conf.HP_COST_TO_FIGHT_ENEMY_IF_ENOUGH_MP);
          Hero.setMP(Hero.getMP()-Conf.MP_COST_TO_FIGHT_ENEMY);
          Hero.setGP(Hero.getGP()+Conf.ENEMY_KILL_BOUNTY);
          Hero.setEK(Hero.getEK()+1);
          Objects.regenerate(enemy);
        }else if(Hero.getHP() > Conf.HP_COST_TO_FIGHT_ENEMY_IF_NOT_ENOUGH_MP && Hero.getMP() < Conf.MP_COST_TO_FIGHT_ENEMY){
          Hero.setLVL(Hero.getLVL()+Conf.ENEMY_KILL_LVL_GAIN);
          Hero.setHP(Hero.getHP()-Conf.HP_COST_TO_FIGHT_ENEMY_IF_NOT_ENOUGH_MP);
          Hero.setGP(Hero.getGP()+Conf.ENEMY_KILL_BOUNTY);
          Hero.setEK(Hero.getEK()+1);
          Objects.regenerate(enemy);
        }else{
          Hero.setHP(0);
        }
      }else{
        Hero.setHP(Hero.getHP()-Conf.HP_COST_TO_RUN_FROM_ENEMY);
      }
    }

    // surprise
    if(Hero.getX() == surprise.getX() && Hero.getY() == surprise.getY() && Tools.dialogC(surprise.getMessage()) == '+'){
      int surpriseBoxValue = Tools.rand(0, 10);
      if(surpriseBoxValue == 0){
        Hero.setHP(Hero.getHP()+Conf.H_RUNE_AMOUNT);
        Tools.dialogC("You found a "+Conf.GREEN+Conf.H_RUNE_NAME+Conf.RESET+"\nEnter any key to continue: ");
      }else if(surpriseBoxValue == 1){
        Hero.setMP(Hero.getMP()+Conf.M_RUNE_AMOUNT);
        Tools.dialogC("You found a "+Conf.CYAN+Conf.M_RUNE_NAME+Conf.RESET+"\nEnter any key to continue: ");
      }else if(surpriseBoxValue == 2){
        Hero.setGP(Hero.getGP()+Conf.G_RUNE_AMOUNT);
        Tools.dialogC("You found a "+Conf.YELLOW+Conf.G_RUNE_NAME+Conf.RESET+"\nEnter any key to continue: ");
      }else{
        Tools.dialogC("You found nothing!\nBetter luck next time :)\nEnter any key to continue: ");
      }
      Objects.regenerate(surprise);
    }

    // secretShop
    if(Hero.getLVL() >= Conf.MIN_LVL_TO_UNLOCK_SECRET_SHOP){
      for(int y=0;y<2;y++){
        for(int x=0;x<2;x++){
          if(Hero.getX() == secretShop.getX()+x && Hero.getY() == secretShop.getY()+y){
            char selection = Tools.dialogC(secretShop.getMessage());

            // Hammer
            if(selection == '1'){
              if(Hero.getLVL()>=Conf.MIN_LVL_TO_UNLOCK_HAMMER){
                if(Hero.getGP()>=Conf.HAMMER_COST){
                  if(Hero.getSlots().get(Conf.HAMMER_NAME) == null){
                    Hero.setSlots(Conf.HAMMER_NAME, Conf.HAMMER_NAME);
                    Tools.dialogC("You purchased a "+Conf.HAMMER_NAME+"! Go do something with it.\nEnter any key to continue: ");
                  }else{Tools.dialogC("You already own it! Don't you know how to use it ?.\nEnter any key to continue: ");}
                }else{Tools.dialogC("Not enough GP! Come later.\nEnter any key to continue: ");}
              }else{Tools.dialogC("Item unavailable! Come later.\nEnter any key to continue: ");}
            }

            // bootsOfSpeeds
            if(selection == '2'){
              if(Hero.getLVL()>=Conf.MIN_LVL_TO_UNLOCK_BOF){
                if(Hero.getGP()>=Conf.BOF_COST){
                  if(Hero.getSlots().get(Conf.BOOTS_OF_SPEED_NAME) == null){
                    Hero.setSlots(Conf.BOOTS_OF_SPEED_NAME, Conf.BOOTS_OF_SPEED_NAME);
                    Tools.dialogC("You purchased a "+Conf.BOOTS_OF_SPEED_NAME+"! Go do something with it.\nEnter any key to continue: ");
                  }else{Tools.dialogC("You already own it! Don't you know how to use it ?.\nEnter any key to continue: ");}
                }else{Tools.dialogC("Not enough GP! Come later.\nEnter any key to continue: ");}
              }else{Tools.dialogC("Item unavailable! Come later.\nEnter any key to continue: ");}
            }

          }
        }
      }
    }

    // BOSS/CASTLE
    if(Hero.getLVL() >= Conf.MIN_LVL_TO_UNLOCK_BOSS){
      // CASTLE
      for(int y=0;y<Conf.BOSS_CASTLE_HEIGHT;y++){
        for(int x=0;x<Conf.BOSS_CASTLE_WIDTH;x++){
          if(Hero.getX() == roshan.getX()+x && Hero.getY() == roshan.getY()+y && roshan.getCastleDestroyed() == false){
            char selection = Tools.dialogC(roshan.getMessage());

            if(selection == '5' && Hero.getSlots().get(Conf.HAMMER_NAME) != null){
              Boss.destroyCastle(roshan);
            }else{
              Hero.setX(Hero.getPX());
              Hero.setY(Hero.getPY());
            }
          }
        }
      }
      // BOSS
      if(Hero.getX() == roshan.getX()+(Conf.BOSS_CASTLE_WIDTH/2) && Hero.getY() == roshan.getY()+(Conf.BOSS_CASTLE_HEIGHT/2)){
        Tools.cls();
        Tools.sleep(1000);
        System.out.println(Conf.RED+"\t\tBe ready final fight is here!"+Conf.RESET+"\n");
        Tools.sleep(2000);
        System.out.println(Conf.RED+Conf.BOSS_NAME+Conf.RESET+" - Nobody can hurt me without my permission!\n");
        Tools.sleep(6000);
        System.out.println(Conf.GREEN+Hero.getName()+Conf.RESET+" - If you can't go back to your mother's womb, you'd better learn to be a good fighter.\n");
        Tools.sleep(6000);
        System.out.println(Conf.RED+Conf.BOSS_NAME+Conf.RESET+" - War means fighting, and fighting means killing!\n");
        Tools.sleep(6000);
        System.out.println(Conf.GREEN+Hero.getName()+Conf.RESET+" - I do not want to die without any scars!\n");
        Hero.setIsBossHasBeenKilled(true);
        Tools.sleep(1000);
      }
    }
  }



}
