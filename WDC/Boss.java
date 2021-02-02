package WDC;

class Boss extends Objects{
  private boolean castleDestroyed = false;

  public Boss(int x, int y, char sign, String message){
    super(x, y, sign, message);
  }

  public boolean getCastleDestroyed(){
    return castleDestroyed;
  }

  public static void destroyCastle(Boss b){
    if(b.castleDestroyed == true){
      Tools.print("Castle already destroyed!!!", Conf.RED);
    }else{
      b.castleDestroyed = true;
    }

  }

  @Override
  public String getMessage(){
    String useHammer = "";
    if(castleDestroyed == false){
      if(Hero.getSlots().get(Conf.HAMMER_NAME)!=null){
        useHammer = "Use "+Conf.HAMMER_NAME+" to destroy the Castle by entering 5: ";
      }
    }else{
      useHammer = "It is time to "+Conf.RED+"Rampage!"+Conf.RESET;
    }
    return super.message+"\nYou stepped into "+Conf.BOSS_NAME+"'s castle.\nTo reach him you must destroy the Castle.\n"+useHammer;
  }
}
