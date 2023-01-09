package com.tpe.idgenereation;

import com.tpe.manytomany.Developer07;
import com.tpe.manytomany.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave08 {

    public static void main(String[] args) {



        Developer08 dev1=new Developer08("HarryPotter","hp@gmail.com","backend");
        Developer08 dev2=new Developer08("Shrek","shrek@gmail.com","frontend");
        Developer08 dev3=new Developer08("JackSparrow","jack@gmail.com","mobile");
        Developer08 dev4=new Developer08("Richie Rich","rich@gmail.com","fullstack");
        Developer08 dev5=new Developer08("Gandalf","gandalf@gmail.com","backend");

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer08.class);// configürasyon olusturduk hibernate ve annote class ile birlikte
        SessionFactory sf=cfg.buildSessionFactory();// session olusturmak için kullanıyoruz.
        //conf dosyasını okur ve uygulama ile database arasında crud operasyonlarını yapmak için kullanıyoruz.
        Session session=sf.openSession();
        Transaction tx = session.beginTransaction(); // parcalanmayan atomik yapıdaki işlemler
        //buarada yapılan bir işlemde hata olursa diger işlemede devamn etmiyor.

        //SEQ=100,101,102,103,104,105
        //SEQ2=106,107,108,109,110
        //SEQ3=111,112,113,114,115

        session.save(dev1);
        session.save(dev2);
        session.save(dev3);
//        session.save(dev4);
//        session.save(dev5);

        tx.commit();
        session.close();
        sf.close();
    }
}
