package RentVehicle.repository;

import RentVehicle.tables.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    Collection<Model> findModelByIdModelType(int ID_Model_Type);
}
