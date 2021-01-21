package lesson5.transport;

public class Bus extends MotorVehicle {
    private float tankVolume;
    private float fuelConcumtion;
    private String stateNumber;
    public Bus (String stateNumber) {
        super(stateNumber);
        tankVolume = 40;
        fuelConcumtion = 7.5f;
    }

    @Override
    public void run () {

    }
}
