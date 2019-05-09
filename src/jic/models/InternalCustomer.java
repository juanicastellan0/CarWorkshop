package jic.models;

public class InternalCustomer extends Customer{
    private User user;
    private Integer discount_rate;

    public InternalCustomer(String name, String email, Long dni, String phone, boolean is_regular_client) {
        super(name, email, dni, phone, is_regular_client);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDiscountRate() {
        return discount_rate;
    }

    public void setDiscountRate(Integer discount_rate) {
        this.discount_rate = discount_rate;
    }
}
