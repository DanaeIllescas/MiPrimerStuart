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
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idartist")
    private int idartist;

    @Column(name = "name_artist", nullable = false, length = 80)
    private String name_artist;

    @Column(name = "last_name", nullable = false, length = 100)
    private String last_name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 45)
    private String phone_number;

    @Column(name = "pass_word", nullable = false, length = 45)
    private String pass_word;

    @Column(name = "birthdate", nullable = false, length = 45)
    private String birthdate;

    @Column(name = "school", nullable = false, length = 45)
    private String school;

    @Column(name = "about", nullable = false)
    private String about;

    @Column(name = "terms_conditions", nullable = false)
    private boolean terms_conditions;

    @OneToMany(mappedBy = "artist")
    private Set<Product> product;

    public Artist() {
        super();
    }

    public Artist(int idartist, String name_artist, String last_name, String email, String phone_number,
            String pass_word, String birthdate, String school, String about, boolean terms_conditions,
            Set<Product> product) {
        super();
        this.idartist = idartist;
        this.name_artist = name_artist;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.pass_word = pass_word;
        this.birthdate = birthdate;
        this.school = school;
        this.about = about;
        this.terms_conditions = terms_conditions;
        this.product = product;
    }

    public int getIdartist() {
        return idartist;
    }

    public void setIdartist(int idartist) {
        this.idartist = idartist;
    }

    public String getName_artist() {
        return name_artist;
    }

    public void setName_artist(String name_artist) {
        this.name_artist = name_artist;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public boolean isTerms_conditions() {
        return terms_conditions;
    }

    public void setTerms_conditions(boolean terms_conditions) {
        this.terms_conditions = terms_conditions;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Artist [idartist=" + idartist + ", name_artist=" + name_artist + ", last_name=" + last_name + ", email="
                + email + ", phone_number=" + phone_number + ", pass_word=" + pass_word + ", birthdate=" + birthdate
                + ", school=" + school + ", about=" + about + ", terms_conditions=" + terms_conditions + ", product="
                + product + "]";
    }
}