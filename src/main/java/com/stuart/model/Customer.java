package com.stuart.model;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity

@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="idcustomer")
    private int idcustomer;
    
    @Column(name="name_customer", nullable=false, length=80)
    private String name_customer;
    
    @Column(name="last_name", nullable=false, length=100)
    private String last_name;
    
    @Column(name="email", nullable=false, length=100)
    private String email;
    
    @Column(name="pass_word", nullable=false, length=45)
    private String pass_word;

    @Column(name="terms_conditions", nullable=false)
    private boolean terms_conditions;
    
    @OneToMany (mappedBy="customer")
    private Set<Order> order;

    public Customer() {
        super();
    }

    public Customer(int idcustomer, String name_customer, String last_name, String email, String pass_word,
            boolean terms_conditions, Set<Order> order) {
        super();
        this.idcustomer = idcustomer;
        this.name_customer = name_customer;
        this.last_name = last_name;
        this.email = email;
        this.pass_word = pass_word;
        this.terms_conditions = terms_conditions;
        this.order = order;
    }

    public int getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public boolean isTerms_conditions() {
        return terms_conditions;
    }

    public void setTerms_conditions(boolean terms_conditions) {
        this.terms_conditions = terms_conditions;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Customer [idcustomer=" + idcustomer + ", name_customer=" + name_customer + ", last_name=" + last_name
                + ", email=" + email + ", pass_word=" + pass_word + ", terms_conditions=" + terms_conditions
                + ", order=" + order + "]";
    }
}