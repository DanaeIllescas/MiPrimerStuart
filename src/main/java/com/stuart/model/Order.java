package com.stuart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idorder")
    private int idorder;
    
    @Column(name="email", nullable=false, length=100)
    private String email;
    
    @Column(name="address", nullable=false, length=250)
    private String address;
    
    @Column(name="phone_number", nullable=false, length=45)
    private String phone_number;
    
    @Column(name="total", nullable=false)
    private float total;
    
    @OneToOne
    @JoinColumn(name="product_idproduct")
    private Product product;

    @ManyToOne
    @JoinColumn(name="customer_idcustomer")
    private Customer customer;

    public Order() {
        super();
    }

    public Order(int idorder, String email, String address, String phone_number, float total, Product product,
            Customer customer) {
        super();
        this.idorder = idorder;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.total = total;
        this.product = product;
        this.customer = customer;
    }

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order [idorder=" + idorder + ", email=" + email + ", address=" + address + ", phone_number="
                + phone_number + ", total=" + total + ", product=" + product + ", customer=" + customer + "]";
    }
}