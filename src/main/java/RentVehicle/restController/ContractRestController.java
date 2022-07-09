package RentVehicle.restController;

import RentVehicle.exception.NotFound;
import RentVehicle.repository.ContractRepository;
import RentVehicle.tables.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractRestController {

    @Autowired
    ContractRepository repository;

    @GetMapping("/all")
    List<Contract> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/all")
    Contract newContract(@RequestBody Contract newContract) {
        return repository.save(newContract);
    }

    // Single item

    @GetMapping("/{id}")
    Contract one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFound(id));
    }

    @PutMapping("/{id}")
    Contract replaceContract(@RequestBody Contract newContract, @PathVariable Long id) {

        return repository.findById(id)
                .map(contract -> {
                    contract.setDateOfConclusion(newContract.getDateOfConclusion());
                    contract.setClient(newContract.getClient());
                    contract.setEmployee(newContract.getEmployee());
                    contract.setVehicle(newContract.getVehicle());
                    contract.setFinalPrice(newContract.getFinalPrice());
                    return repository.save(contract);
                })
                .orElseGet(() -> {
                    newContract.setIdContract(id);
                    return repository.save(newContract);
                });
    }

    @DeleteMapping("/{id}")
    void deleteContract(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
