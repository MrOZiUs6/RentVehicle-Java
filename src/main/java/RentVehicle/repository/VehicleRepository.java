package RentVehicle.repository;

import RentVehicle.tables.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public
interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Collection<Vehicle> findVehicleBySerialNumber(int Serial_Number);

}
