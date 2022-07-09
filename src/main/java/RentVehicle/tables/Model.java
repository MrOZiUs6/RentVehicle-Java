package RentVehicle.tables;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Model", schema = "public")
public class Model {
    @Id
    @Column(name = "ID_Model_Type")
    private Long idModelType;
    @Column(name = "Model_Type")
    private String modelType;
    @Column(name = "Number_of_Wheels")
    private int numberOfWheels;
    @Column(name = "Number_of_Seats")
    private int numberOfSeats;
    @Column(name = "Wheel_Size")
    private int wheelSize;
    @Column(name = "Wheel_Type")
    private String wheelType;
    @Column(name = "Frame_Type")
    private String frameType;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model")
    List<Vehicle> model;

    public Model() {
    }

    public Long getIdModelType() {
        return idModelType;
    }

    public void setIdModelType(Long idModelType) {
        this.idModelType = idModelType;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getWheelType() {
        return wheelType;
    }

    public void setWheelType(String wheelType) {
        this.wheelType = wheelType;
    }

    public String getFrameType() {
        return frameType;
    }

    public void setFrameType(String frameType) {
        this.frameType = frameType;
    }

    public List<Vehicle> getModel() {
        return model;
    }

    public void setModel(List<Vehicle> model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Model{" +
                "idModelType=" + idModelType +
                ", modelType='" + modelType + '\'' +
                ", numberOfWheels=" + numberOfWheels +
                ", numberOfSeats=" + numberOfSeats +
                ", wheelSize=" + wheelSize +
                ", wheelType='" + wheelType + '\'' +
                ", frameType='" + frameType + '\'' +
                '}';
    }
}
