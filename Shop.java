package WDC;

class Shop extends Objects{
  public Shop(int x, int y, char sign, String message){
    super(x, y, sign, message);
  }

  @Override
  public String getMessage(){
    String hammer = "\n\n1.\tName: "+Conf.HAMMER_NAME+"\n\tCost:"+Conf.HAMMER_COST+" GP\n\tAvailability: At level "+Conf.MIN_LVL_TO_UNLOCK_HAMMER+"\n\tDescription: "+Conf.HAMMER_DESC;
    String bootsOfSpeeds = "\n\n2.\tName: "+Conf.BOOTS_OF_SPEED_NAME+"\n\tCost: "+Conf.BOF_COST+" GP\n\tAvailability: At level "+Conf.MIN_LVL_TO_UNLOCK_BOF+"\n\tDescription: "+Conf.BOF_DESC;
    return super.message+hammer+bootsOfSpeeds+"\n\nEnter index number of items to buy or any other non index number to move on: ";
  }
}
