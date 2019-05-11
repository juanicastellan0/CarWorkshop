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

    public RepairOrder(Car car, String problem_description, Date admission_date, Date repair_date, Long repair_price) {
        this.car = car;
        this.problem_description = problem_description;
        this.admission_date = admission_date;
        this.repair_date = repair_date;
        this.repair_price = repair_price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public static RepairOrder search(Scanner scanner, ArrayList<RepairOrder> repair_orders) {
        String repair_order_id;
        System.out.println("Enter the repair order id: ");
        repair_order_id = scanner.nextLine();
        for (RepairOrder repair_order : repair_orders) {
            if (repair_order.getId().equals(repair_order_id)) {
                return repair_order;
            }
        }
        System.out.println("Repair order not found: ");
        return null;
    }
}
