public abstract class Vehicle implements Runnable{
    protected final String LICENCE_NUMBER;
    protected final int TIME_FOR_WASH;
    


    public Vehicle(String licenceNumber, int time_for_wash){
        this.LICENCE_NUMBER = licenceNumber;
        this.TIME_FOR_WASH = time_for_wash;
    }

    @Override
    public String toString() {
     
        return "Vehicle type: "+this.getClass().getSimpleName()+" Licence nuber: "+LICENCE_NUMBER;
    }

    public void getToLine(){
        System.out.println("Arrived to Vehicla washer queue\n"+this);
    }
    public void getToWasherMachine(){
        System.out.println("Enter to washing machine\n"+this);
    }
    public void exitWasher(){
        System.out.println("Finish washing\n"+this);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(TIME_FOR_WASH);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }


    
}
