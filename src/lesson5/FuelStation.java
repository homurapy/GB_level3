package lesson5;

import lesson5.transport.MotorVehicle;

import java.util.concurrent.Semaphore;

public class FuelStation {
    Semaphore semaphore = new Semaphore(3);

    public float filling (MotorVehicle motorVehicle){
        try {
            System.out.println(motorVehicle.getStateNumber() + " is await filling fuel...");
            semaphore.acquire();
            Thread.sleep(5000);
            System.out.println(motorVehicle.getStateNumber() + " was filled fuel...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return motorVehicle.getTankVolume();
    }
}



