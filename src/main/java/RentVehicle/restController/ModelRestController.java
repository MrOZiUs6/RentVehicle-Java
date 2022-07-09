package RentVehicle.restController;

import RentVehicle.exception.NotFound;
import RentVehicle.repository.ModelRepository;
import RentVehicle.tables.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelRestController {

    @Autowired
    ModelRepository repository;

    @GetMapping("/all")
    List<Model> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/all")
    Model newModel(@RequestBody Model newModel) {
        return repository.save(newModel);
    }

    // Single item

    @GetMapping("/{id}")
    Model one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFound(id));
    }

    @PutMapping("/{id}")
    Model replaceModel(@RequestBody Model newModel, @PathVariable Long id) {

        return repository.findById(id)
                .map(model -> {
                    model.setModelType(newModel.getModelType());
                    model.setNumberOfWheels(newModel.getNumberOfWheels());
                    model.setNumberOfSeats(newModel.getNumberOfSeats());
                    model.setWheelSize(newModel.getWheelSize());
                    model.setWheelType(newModel.getWheelType());
                    model.setFrameType(newModel.getFrameType());
                    return repository.save(model);
                })
                .orElseGet(() -> {
                    newModel.setIdModelType(id);
                    return repository.save(newModel);
                });
    }

    @DeleteMapping("/{id}")
    void deleteModel(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
