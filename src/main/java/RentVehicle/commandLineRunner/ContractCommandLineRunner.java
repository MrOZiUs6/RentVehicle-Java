package RentVehicle.commandLineRunner;

import RentVehicle.repository.ContractRepository;
import RentVehicle.tables.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ContractCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        for (Contract c : this.contractRepository.findAll())
            System.out.println(c.toString());
    }

    @Autowired
    ContractRepository contractRepository;
}
