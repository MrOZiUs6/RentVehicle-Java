package RentVehicle.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Contract", schema = "public")
public class Contract {
    @Id
    @Column(name = "ID_Contract")
    private Long idContract;
    @Column(name = "Date_of_Conclusion")
    private Timestamp dateOfConclusion;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "Document_Number")
    Client client;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_Employee")
    Employee employee;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "Serial_Number")
    Vehicle vehicle;
    @Column(name = "Final_Price")
    private Long finalPrice;

    public Contract() {}

    public Long getIdContract() {
        return idContract;
    }

    public void setIdContract(Long idContract) {
        this.idContract = idContract;
    }

    public Timestamp getDateOfConclusion() {
        return dateOfConclusion;
    }

    public void setDateOfConclusion(Timestamp dateOfConclusion) {
        this.dateOfConclusion = dateOfConclusion;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Long finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idContract=" + idContract +
                ", dateOfConclusion=" + dateOfConclusion +
                ", client=" + client +
                ", employee=" + employee +
                ", vehicle=" + vehicle +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
