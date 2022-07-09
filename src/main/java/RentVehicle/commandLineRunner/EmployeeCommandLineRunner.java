package RentVehicle.commandLineRunner;


import RentVehicle.repository.EmployeeRepository;
import RentVehicle.tables.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class EmployeeCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        for (Employee e : this.employeeRepository.findAll())
            System.out.println(e.toString());
    }

    @Autowired
    EmployeeRepository employeeRepository;
}
