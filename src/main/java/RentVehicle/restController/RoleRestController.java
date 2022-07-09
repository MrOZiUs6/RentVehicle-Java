package RentVehicle.restController;

import RentVehicle.exception.NotFound;
import RentVehicle.repository.RoleRepository;
import RentVehicle.tables.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
class RoleRestController {

    @Autowired
    RoleRepository repository;

    @GetMapping("/all")
    List<Role> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/all")
    Role newRole(@RequestBody Role newRole) {
        return repository.save(newRole);
    }

    // Single item

    @GetMapping("/{id}")
    Role one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFound(id));
    }

    @PutMapping("/{id}")
    Role replaceRole(@RequestBody Role newRole, @PathVariable Long id) {

        return repository.findById(id)
                .map(role -> {
                    role.setNameRole(newRole.getNameRole());
                    return repository.save(role);
                })
                .orElseGet(() -> {
                    newRole.setIdRole(id);
                    return repository.save(newRole);
                });
    }

    @DeleteMapping("/{id}")
    void deleteRole(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
