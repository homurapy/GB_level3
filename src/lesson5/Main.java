package lesson5;

import com.sun.jdi.connect.Transport;
import lesson5.transport.Bus;
import lesson5.transport.Car;
import lesson5.transport.Truck;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main (String[] args) {
        FuelStation fuelStation = new FuelStation();
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(() ->new Bus("Bus1").traffic(fuelStation));
        service.execute(() ->new Bus("Bus2").traffic(fuelStation));
        service.execute(() ->new Car("Car1").traffic(fuelStation));
        service.execute(() ->new Car("Car2").traffic(fuelStation));
        service.execute(() ->new Car("Car3").traffic(fuelStation));
        service.execute(() ->new Car("Car4").traffic(fuelStation));
        service.execute(() ->new Car("Car5").traffic(fuelStation));
        service.execute(() ->new Car("Car6").traffic(fuelStation));
        service.execute(() ->new Truck("Truck1").traffic(fuelStation));
        service.execute(() ->new Truck("Truck2").traffic(fuelStation));
        service.shutdown();
    }

}

