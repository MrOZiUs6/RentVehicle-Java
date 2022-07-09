package RentVehicle.repository;

import RentVehicle.tables.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public
interface ClientRepository extends JpaRepository<Client, Long> {
    Collection<Client> findClientByDocumentNumber(Long Document_Number);
}
