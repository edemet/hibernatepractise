package com.tpe.idgenereation;

import javax.persistence.*;

@Entity
public class Developer08 {
    @Id
    @SequenceGenerator(name = "squence",sequenceName = "dev8_seq",initialValue = 100,allocationSize = 5)
    //allocation size 'verdiğimiz deger kadar 5 tane id iceren set olusturur.ikinci insert 106'dAN BASLAR .
    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE) //Auto olursa cok yavas cok tercih edilmez.
    //identity yöntemini zorunlu yapar kontrol data basede ' her inputa unıq ıd'ler database tarafından olusturulur.
    private Long id;

    private String name;
    private  String email;
    private String branch;


    public Developer08(){}

    public Developer08(String name, String email, String branch) {
        this.name = name;
        this.email = email;
        this.branch = branch;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

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
}
