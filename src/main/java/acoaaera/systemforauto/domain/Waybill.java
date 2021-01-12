package acoaaera.systemforauto.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table
public class Waybill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "autos")
    private Auto autos;
    @ManyToOne()
    @JoinColumn(name = "driver")
    private User driver;
    private LocalDateTime dateOfDeparture;
    private Timestamp dateOfArrival;
    private Long countFuel;
    private Long odometr;
    private String route;
    private Long request;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Auto getAutos() {
        return autos;
    }

    public void setAutos(Auto autos) {
        this.autos = autos;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public LocalDateTime getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDateTime dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public Timestamp getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Timestamp dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public Long getCountFuel() {
        return countFuel;
    }

    public void setCountFuel(Long countFuel) {
        this.countFuel = countFuel;
    }

    public Long getOdometr() {
        return odometr;
    }

    public void setOdometr(Long odometr) {
        this.odometr = odometr;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Long getRequest() {
        return request;
    }

    public void setRequest(Long request) {
        this.request = request;
    }
}
