package lesson5.transport;

import lesson5.FuelStation;

public abstract class MotorVehicle implements Runnable{
    private float tankVolume;
    private float fuelConcumtion;
    private String stateNumber;
    private float reminingFuel;
    public MotorVehicle (String stateNumber){
        this.stateNumber = stateNumber;
        tankVolume = 20;
        fuelConcumtion = 2.5F;
    }
    public void traffic(FuelStation fuelStation) {
        reminingFuel = this.tankVolume;
        while (true){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reminingFuel -= fuelConcumtion;
            if (reminingFuel <= 0) {
                System.out.println(stateNumber + " ran out of gas");
                System.out.println(stateNumber + " went to the gas station");
                reminingFuel = fuelStation.filling(this);
                System.out.println(stateNumber + " returned to the route");
            }
            else{
                System.out.println(stateNumber + " driving along the route");
            }
        }
    }
    public String getStateNumber () {
        return stateNumber;
    }
    public float getTankVolume () {
        return tankVolume;
    }
}
