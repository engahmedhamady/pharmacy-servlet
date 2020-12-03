package com.store.dal.entities;
// Generated Jul 8, 2020 8:01:12 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customer",
         catalog = "pharmacy_management"
)
public class Customer implements java.io.Serializable {

    private int ID;
    private String name;
    private String email;
    private String phone;

    public Customer() {
    }

    public Customer(int ID,String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.ID = ID;
    }

   @Id

    @Column(name = "ID", unique = true, nullable = false, length = 13)
    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone", nullable = false, length = 100)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
