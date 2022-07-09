package RentVehicle.tables;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Client", schema = "public")
public class Client {
    @Id
    @Column(name = "Document_Number")
    private Long documentNumber;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Name")
    private String name;
    @Column(name = "Patronymic")
    private String patronymic;
    @Column(name = "Telephone_Number")
    private long telephoneNumber;
    @Column(name = "Password")
    private String password;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "client")
    List<Contract> client;

    public Client() {}

    public Long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
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

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "documentNumber=" + documentNumber +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                ", password='" + password + '\'' +
                '}';
    }
}
