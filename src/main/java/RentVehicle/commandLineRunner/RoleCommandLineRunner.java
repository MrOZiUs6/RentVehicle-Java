package RentVehicle.commandLineRunner;

import RentVehicle.repository.RoleRepository;
import RentVehicle.tables.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class RoleCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        for (Role r : this.roleRepository.findAll())
            System.out.println(r.toString());
    }

    @Autowired
    RoleRepository roleRepository;
}
