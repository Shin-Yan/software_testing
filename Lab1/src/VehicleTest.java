import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    private Vehicle vehicle1;
    private Vehicle vehicle2;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        vehicle1 = new Vehicle();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        vehicle1.finalize();
    }

    @org.junit.jupiter.api.Test
    void testFinalize() {
        vehicle2 = new Vehicle();
        int total = 2;
        assertEquals(vehicle2.totalVehicle(),total);
        total = total-1 ;
        vehicle2.finalize();
        assertEquals(vehicle1.totalVehicle(),total);
    }

    @org.junit.jupiter.api.Test
    void setSpeed() {
        vehicle1.setSpeed(1);
        int speed = 1;
        assertEquals(speed, vehicle1.getSpeed());
    }

    @org.junit.jupiter.api.Test
    void setDir() {
        vehicle1.setDir("south");
        String direction = "south";
        assertEquals(direction, vehicle1.getDir());
    }

    @org.junit.jupiter.api.Test
    void getSpeed() {
        int speed = 0;
        assertEquals(speed, vehicle1.getSpeed());
    }

    @org.junit.jupiter.api.Test
    void getDir() {
        String direction = "north";
        assertEquals(direction, vehicle1.getDir());
    }

    @org.junit.jupiter.api.Test
    void totalVehicle() {
        int totalVehicle = 1;
        assertEquals(totalVehicle,vehicle1.totalVehicle());
    }
}