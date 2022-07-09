package RentVehicle.tables;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Role", schema = "public")
public class Role {
    @Id
    @Column(name = "ID_Role")
    private Long idRole;
    @Column(name = "Name_Role")
    private String nameRole;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "role")
    List<Employee> role;

    public Role() {}

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public List<Employee> getRole() {
        return role;
    }

    public void setRole(List<Employee> role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", nameRole='" + nameRole + '\'' +
                '}';
    }
}
