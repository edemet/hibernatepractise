package com.tpe.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {

    public static void main(String[] args) {

        Company com1 = new Company(11L, "Google");
        Company com2 = new Company(22L, "Amazon");

        Developer04 dev1=new Developer04(1L,"HarryPotter","hp@gmail.com","backend",com1);
        Developer04 dev2=new Developer04(2L,"Shrek","shrek@gmail.com","frontend",com1);
        Developer04 dev3=new Developer04(3L,"JackSparrow","jack@gmail.com","mobile",com2);
        Developer04 dev4=new Developer04(4L,"Richie Rich","rich@gmail.com","fullstack",com2);
        Developer04 dev5=new Developer04(5L,"Gandalf","gandalf@gmail.com","backend",com2);


        org.hibernate.cfg.Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer04.class).addAnnotatedClass(Company.class);// configürasyon olusturduk hibernate ve annote class ile birlikte
        SessionFactory sf=cfg.buildSessionFactory();// session olusturmak için kullanıyoruz.
        //conf dosyasını okur ve uygulama ile database arasında crud operasyonlarını yapmak için kullanıyoruz.
        Session session=sf.openSession();
        Transaction tx = session.beginTransaction(); // parcalanmayan atomik yapıdaki işlemler
        //buarada yapılan bir işlemde hata olursa diger işlemede devamn etmiyor.

        session.save(com1);
        session.save(com2);

        session.save(dev1);
        session.save(dev2);
        session.save(dev3);
        session.save(dev4);
        session.save(dev5);

        tx.commit();
        session.close();
        sf.close();


    }
}
