public class VehicleWasher {
    Queue<Vehicle> washerQueue = new Queue<>();
    Vehicle[] washingMachines;
    int freePlace=0;
    Object lock1 = new Object();


    public VehicleWasher(int numOfWasers){
        this.washingMachines = new Vehicle[numOfWasers];
        for(int i=1; i<numOfWasers; i++){
            freePlace*=10;
            freePlace +=i;
        }
       
    }

    public boolean isFull(){
       return Math.log10(freePlace) == washingMachines.length;
    }

    public void insertIntoLine(Vehicle vehicle){
        synchronized(washerQueue){
            washerQueue.enqueue(vehicle);
            vehicle.getToLine();
        }
    }
    public void insertIntoWasher(){
        Vehicle vehicle;
        int index;
        while(isFull()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized(washingMachines){
            synchronized(washerQueue){
                vehicle = washerQueue.dequeue();
            }
            synchronized(lock1){
                index = freePlace%10;
                freePlace/=10;
            }
            washingMachines[index] = vehicle;
        }
        
       
    }




}
