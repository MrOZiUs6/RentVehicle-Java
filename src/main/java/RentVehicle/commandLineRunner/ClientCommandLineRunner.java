package RentVehicle.commandLineRunner;

import RentVehicle.repository.ClientRepository;
import RentVehicle.tables.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class ClientCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        for (Client c : this.clientRepository.findAll())
            System.out.println(c.toString());
    }

    @Autowired
    ClientRepository clientRepository;
}
