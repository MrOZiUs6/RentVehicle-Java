package RentVehicle.repository;

import RentVehicle.tables.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public
interface ContractRepository extends JpaRepository<Contract, Long> {
    Collection<Contract> findContractByIdContract(int ID_Contract);
}
