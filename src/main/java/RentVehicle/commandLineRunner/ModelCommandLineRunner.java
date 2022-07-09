package RentVehicle.commandLineRunner;

import RentVehicle.repository.ModelRepository;
import RentVehicle.tables.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class ModelCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        for (Model m : this.modelRepository.findAll())
            System.out.println(m.toString());
    }

    @Autowired
    ModelRepository modelRepository;
}
