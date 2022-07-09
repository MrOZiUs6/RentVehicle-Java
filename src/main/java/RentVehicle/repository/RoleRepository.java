package RentVehicle.repository;

import RentVehicle.tables.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public
interface RoleRepository extends JpaRepository<Role, Long> {
    Collection<Role> findRoleByIdRole(int ID_Role);

    //@Override
    //Optional<Client> findClientByDocumentNumber(Long DN);
}
