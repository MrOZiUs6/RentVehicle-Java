package RentVehicle.restController;

import RentVehicle.exception.NotFound;
import RentVehicle.repository.ClientRepository;
import RentVehicle.tables.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/client")
class ClientRestController {

    @Autowired
    ClientRepository repository;

    @GetMapping("/all")
    List<Client> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/all")
    Client newClient(@RequestBody Client newClient) {
        return repository.save(newClient);
    }

    // Single item

    @GetMapping("/{Document_Number}")
    Client one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFound(id));
    }

    @PutMapping("/{Document_Number}")
    Client replaceClient(@RequestBody Client newClient, @PathVariable Long id) {

        return repository.findById(id)
                .map(client -> {
                    client.setSurname(newClient.getSurname());
                    client.setName(newClient.getName());
                    client.setPatronymic(newClient.getPatronymic());
                    client.setTelephoneNumber(newClient.getTelephoneNumber());
                    client.setPassword(newClient.getPassword());
                    return repository.save(client);
                })
                .orElseGet(() -> {
                    newClient.setDocumentNumber(id);
                    return repository.save(newClient);
                });
    }

    @DeleteMapping("/{id}")
    void deleteClient(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
