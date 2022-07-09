package RentVehicle.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Employee", schema = "public")
public class Employee {
    @Id
    @Column(name = "ID_Employee")
    private Long idEmployee;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Name")
    private String name;
    @Column(name = "Patronymic")
    private String patronymic;
    @Column(name = "Login")
    private String login;
    @Column(name = "Password")
    private String password;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_Role")
    Role role;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee")
    List<Contract> employee;

    public Employee() {}

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
