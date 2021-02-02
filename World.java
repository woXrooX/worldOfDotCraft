package WDC;

class World extends Game{
  private static char[][] map = new char[Conf.MAP_HEIGHT][Conf.MAP_WIDTH];

  private static char[][] generateMap(){
    for(int y=0;y<map.length;y++){
      for(int x=0;x<map[y].length;x++){
        if(y == 0 || y == map.length-1){
          map[y][x] = '-';
        }else if(x == 0 || x == map[y].length-1){
          map[y][x] = '|';
        }else{
          map[y][x] = ' ';
        }
      }
    }

    placeObjects(health);
    placeObjects(mana);
    placeObjects(gold);
    placeObjects(enemy);
    placeObjects(surprise);

    if(Hero.getLVL() >= Conf.MIN_LVL_TO_UNLOCK_SECRET_SHOP){
      placeObjects(secretShop);
    }

    if(Hero.getLVL() >= Conf.MIN_LVL_TO_UNLOCK_BOSS){
      placeObjects(roshan);
    }

    try{
      map[Hero.getY()][Hero.getX()] = 'P';
    }catch(ArrayIndexOutOfBoundsException e){
      if(Hero.getY()<0) Hero.setY(Conf.MAP_HEIGHT-1);
      if(Hero.getY()>=Conf.MAP_HEIGHT) Hero.setY(0);
      if(Hero.getX()<0) Hero.setX(Conf.MAP_WIDTH-1);
      if(Hero.getX()>=Conf.MAP_WIDTH) Hero.setX(0);

      Objects.regenerate(health);
      Objects.regenerate(mana);
      Objects.regenerate(gold);
      Objects.regenerate(enemy);
      Objects.regenerate(surprise);
      Objects.regenerate(secretShop);
      Objects.regenerate(roshan);
      generateMap();
    }

    return map;
  }

  private static void placeObjects(Objects r){
    if(r.getClass().getName().equals("WDC.Objects")){
      map[r.getY()][r.getX()] = r.getSign();
    }else if(r.getClass().getName().equals("WDC.Shop")){
      for(int y=0;y<2;y++){
        for(int x=0;x<2;x++){
          map[r.getY()+y][r.getX()+x] = r.getSign();
        }
      }
    }else if(r.getClass().getName().equals("WDC.Boss")){
      for(int y=0;y<Conf.BOSS_CASTLE_HEIGHT;y++){
        for(int x=0;x<Conf.BOSS_CASTLE_WIDTH;x++){
          map[r.getY()+y][r.getX()+x] = roshan.getCastleDestroyed()?'^':'#';
        }
      }
      map[r.getY()+(Conf.BOSS_CASTLE_HEIGHT/2)][r.getX()+(Conf.BOSS_CASTLE_WIDTH/2)] = r.getSign();
    }
  }

  public static void draw(){
    for(char[] y:generateMap()){
      for(char x:y){
             if(x == 'H')Tools.print("H", Conf.GREEN);
        else if(x == 'M')Tools.print("M", Conf.CYAN);
        else if(x == 'G')Tools.print("G", Conf.YELLOW);
        else if(x == 'E')Tools.print("E", Conf.RED);
        else if(x == 'S')Tools.print("S", Conf.BLUE);
        else if(x == 'R')Tools.print("R", Conf.RED);
        else if(x == '#')Tools.print("#", Conf.BLUE);
        else System.out.print(x);
      }
      System.out.println();
    }
  }
}
