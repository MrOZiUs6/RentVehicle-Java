package RentVehicle.restController;

import RentVehicle.exception.NotFound;
import RentVehicle.repository.VehicleRepository;
import RentVehicle.tables.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleRestController {

    @Autowired
    VehicleRepository repository;

    @GetMapping("/all")
    List<Vehicle> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/all")
    Vehicle newVehicle(@RequestBody Vehicle newVehicle) {
        return repository.save(newVehicle);
    }

    // Single item

    @GetMapping("/{Serial_Number}")
    Vehicle one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFound(id));
    }

    @PutMapping("/{Serial_Number}")
    Vehicle replaceVehicle(@RequestBody Vehicle newVehicle, @PathVariable Long id) {

        return repository.findById(id)
                .map(vehicle -> {
                    vehicle.setModel(newVehicle.getModel());
                    vehicle.setLifeTime(newVehicle.getLifeTime());
                    vehicle.setRentalPrice(newVehicle.getRentalPrice());
                    return repository.save(vehicle);
                })
                .orElseGet(() -> {
                    newVehicle.setSerialNumber(id);
                    return repository.save(newVehicle);
                });
    }

    @DeleteMapping("/{id}")
    void deleteVehicle(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
