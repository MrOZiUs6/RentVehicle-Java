package RentVehicle.repository;

import RentVehicle.tables.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public
interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Collection<Employee> findEmployeeByIdEmployee(int ID_Employee);
}
