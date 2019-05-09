package jic.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RepairOrder {
    String id;
    private Car car;
    private String problem_description;
    private Date admission_date;
    private Date repair_date;
    private Long repair_price;
    private User registered_by;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getProblemDescription() {
        return problem_description;
    }

    public void setProblemDescription(String problem_description) {
        this.problem_description = problem_description;
    }

    public Date getAdmissionDate() {
        return admission_date;
    }

    public void setAdmissionDate(Date admission_date) {
        this.admission_date = admission_date;
    }

    public Date getRepairDate() {
        return repair_date;
    }

    public void setRepairDate(Date repair_date) {
        this.repair_date = repair_date;
    }

    public Long getRepairPrice() {
        return repair_price;
    }

    public void setRepairPrice(Long repair_price) {
        this.repair_price = repair_price;
    }

    public User getRegisteredBy() {
        return registered_by;
    }

    public void setRegisteredBy(User registered_by) {
        this.registered_by = registered_by;
    }
}
