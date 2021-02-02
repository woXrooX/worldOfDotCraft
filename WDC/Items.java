package WDC;

class Items{
  private static int count = 1;
  private int id = 0;

  private String name;
  private String description;
  private double minLvlToUnlock;
  private int cost;
  private int buff;

  public Items(String name, String description, double minLvlToUnlock, int cost, int buff){
    this.name = name;
    this.description = description;
    this.minLvlToUnlock = minLvlToUnlock;
    this.cost = cost;
    this.buff = buff;

    id=count++;
  }


  public String getName(){return this.name;}
  public String getDescription(){return this.description;}
  public double getMinLvlToUnlock(){return this.minLvlToUnlock;}
  public int getCost(){return this.cost;}
  public int getBuffs(){return this.buff;}
  public int getId(){return this.id;}
}
