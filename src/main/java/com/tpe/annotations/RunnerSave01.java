package com.tpe.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

    public static void main(String[] args) {

        Developer01 dev1= new Developer01(1,"Harry Potter","gp@gmail.com","backend");
        Developer01 dev2= new Developer01(2,"Shrek","sh@gmail.com","frontend");
        Developer01 dev3= new Developer01(3,"Jack Sparrow","js@gmail.com","mobile");

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer01.class);// configürasyon olusturduk hibernate ve annote class ile birlikte
        SessionFactory sf=cfg.buildSessionFactory();// session olusturmak için kullanıyoruz.
        //conf dosyasını okur ve uygulama ile database arasında crud operasyonlarını yapmak için kullanıyoruz.
        Session session=sf.openSession();
        Transaction tx = session.beginTransaction(); // parcalanmayan atomik yapıdaki işlemler
        //buarada yapılan bir işlemde hata olursa diger işlemede devamn etmiyor.


        session.save(dev1);
        session.save(dev2);
        session.save(dev3);

        tx.commit(); // transaction'ı bunun ile kapatıyoruz. commit olmazsa save yapmaz..
        session.close();
        sf.close();

    }
}
