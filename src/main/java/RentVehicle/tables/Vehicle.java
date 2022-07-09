package RentVehicle.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Vehicle", schema = "public")
public class Vehicle {
    @Id
    @Column(name = "Serial_Number")
    private Long serialNumber;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_Model_Type")
    Model model;
    @Column(name = "Life_Time")
    private int lifeTime;
    @Column(name = "Rental_Price")
    private Long rentalPrice;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "vehicle")
    List<Contract> vehicle;

    public Vehicle() {}

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public Long getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Long rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public List<Contract> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Contract> vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "serialNumber=" + serialNumber +
                ", lifeTime=" + lifeTime +
                ", rentalPrice=" + rentalPrice +
                '}';
    }
}
