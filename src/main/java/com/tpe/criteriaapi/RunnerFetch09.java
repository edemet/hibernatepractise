package com.tpe.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {

    public static void main(String[] args) {



        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer09.class);// configürasyon olusturduk hibernate ve annote class ile birlikte
        SessionFactory sf=cfg.buildSessionFactory();// session olusturmak için kullanıyoruz.
        //conf dosyasını okur ve uygulama ile database arasında crud operasyonlarını yapmak için kullanıyoruz.
        Session session=sf.openSession();
        Transaction tx = session.beginTransaction();

        //Task1 id'si 1 olan dev'in simini Sezai Karakoç OLRAK UPDATE EDİNİZ

        Developer09 dev=session.get(Developer09.class,1L);
        dev.setName("Sezai Karakoç");
        session.update(dev);

       // TASK:id si 1 olan dev in ismini Şair Sezai Karakoç olarak update ediniz hql ile

        String hql="UPDATE Developer09 d SET ";


       // **odevv TASK:parametre kullanarak salarysi 7000 den az olan devlerin salarysini 7850 yapınız.


        tx.commit();
        session.close();
        sf.close();
    }
}
