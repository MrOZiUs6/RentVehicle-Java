package RentVehicle.commandLineRunner;

import RentVehicle.repository.VehicleRepository;
import RentVehicle.tables.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class VehicleCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        for (Vehicle v : this.vehicleRepository.findAll())
            System.out.println(v.toString());
    }

    @Autowired
    VehicleRepository vehicleRepository;

}
