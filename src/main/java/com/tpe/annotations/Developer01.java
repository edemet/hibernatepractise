package com.tpe.annotations;

import javax.persistence.*;

@Entity //dataları persistence yapmak icin kullanıyoruz.
@Table(name="t_developer01")// table adını degistirmek istersek (
public class Developer01 {

    @Id
    private int id;


    @Column(name="developer_name",length = 50,nullable = false)// sutunu adını değiştirilebiliriz.
    private  String name;
    @Column(unique = true)
    private String email;

    //@Transient //database de görünmesini istemiyorsak Transient kullanıyoruz
    private String branch;


    public Developer01(){ } //Bos Constructor

    public Developer01(int id, String name, String email, String branch) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Developer01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
