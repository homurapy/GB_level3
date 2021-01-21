package lesson5.transport;

public class Truck extends MotorVehicle {
    private float tankVolume;
    private float fuelConcumtion;
    private String stateNumber;
    public Truck (String stateNumber) {
        super(stateNumber);
        tankVolume = 60;
        fuelConcumtion = 15f;
    }

    @Override
    public void run () {

    }
}
