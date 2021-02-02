package WDC;

class Objects{
  private int x;
  private int y;
  private char sign;
  protected String message;

  public Objects(int x, int y, char sign, String message){
    this.x = x;
    this.y = y;
    this.sign = sign;
    this.message = message;
  }

  public int getX(){return this.x;}
  public int getY(){return this.y;}
  public char getSign(){return this.sign;}

  public String getMessage(){
    return this.message;
  }

  public static void regenerate(Objects o){
    if(o.getClass().getName().equals("WDC.Objects")){
      o.x = Tools.rand(1, Conf.MAP_WIDTH-2);
      o.y = Tools.rand(1, Conf.MAP_HEIGHT-2);
    }else if(o.getClass().getName().equals("WDC.Shop")){
      o.x = Tools.rand(1, Conf.MAP_WIDTH-3);
      o.y = Tools.rand(1, Conf.MAP_HEIGHT-3);
    }else if(o.getClass().getName().equals("WDC.Boss")){
      o.x = Tools.rand(1, Conf.MAP_WIDTH-2-Conf.BOSS_CASTLE_WIDTH);
      o.y = Tools.rand(1, Conf.MAP_HEIGHT-2-Conf.BOSS_CASTLE_HEIGHT);      
    }
  }
}
