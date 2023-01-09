package com.tpe.onetomany_uni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company2 {




    @Id
    private Long id;

    @Column(unique = true)
    private String companyname;

    //companyde calisan dev'leri görmek istersek //companyden developer'lara ulasacagız.
    @OneToMany
    @JoinColumn(name="company_id") //dev table'ında bir fk olusturur.
    //join column kullanmazsak jointable üretilir 3. atblo olusturur ve company ıd ile develeloperların bilgilerinin tutuldugu. ancak bunun
    // yerine joın column ile fk ile çözüyoruz
    //3 table olusturulur.
    private Set<Developer05> devs=new HashSet<>(); //tekrarlı yapı olmaycaksa set kullandık.
    public Company2() {
    }

    public Company2(Long id, String companyname) {
        this.id = id;
        this.companyname = companyname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Set<Developer05> getDevs() {
        return devs;
    }
    public void setDevs(Set<Developer05> devs) {
        this.devs = devs;
    }

    @Override
    public String toString() {
        return "Company2{" +
                "id=" + id +
                ", companyname='" + companyname + '\'' +
                '}';
    }


}
