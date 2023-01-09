package com.tpe.manytomany;

import com.tpe.manytoone.Company;
import com.tpe.manytoone.Developer04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class RunnerSave07 {

    public static void main(String[] args) {

        Project project1=new Project(11L,"CarRentalApp");
        Project project2=new Project(22L,"AtmApp");

        Developer07 dev1=new Developer07(1L,"HarryPotter","hp@gmail.com","backend");
        Developer07 dev2=new Developer07(2L,"Shrek","shrek@gmail.com","frontend");
        Developer07 dev3=new Developer07(3L,"JackSparrow","jack@gmail.com","mobile");
        Developer07 dev4=new Developer07(4L,"Richie Rich","rich@gmail.com","fullstack");
        Developer07 dev5=new Developer07(5L,"Gandalf","gandalf@gmail.com","backend");


        Set<Developer07> devSet=new HashSet<Developer07>();

        devSet.add(dev1);
        devSet.add(dev2);
        project1.setDevelopers(devSet);

        Set<Developer07> devSet2=new HashSet<Developer07>();

        devSet2.add(dev1);
        devSet2.add(dev2);
        devSet2.add(dev3);
        project2.setDevelopers(devSet2);



        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer07.class).addAnnotatedClass(Project.class);// configürasyon olusturduk hibernate ve annote class ile birlikte
        SessionFactory sf=cfg.buildSessionFactory();// session olusturmak için kullanıyoruz.
        //conf dosyasını okur ve uygulama ile database arasında crud operasyonlarını yapmak için kullanıyoruz.
        Session session=sf.openSession();
        Transaction tx = session.beginTransaction(); // parcalanmayan atomik yapıdaki işlemler
        //buarada yapılan bir işlemde hata olursa diger işlemede devamn etmiyor.

        session.save(project1);
        session.save(project2); //CACADE TYPE ALL DEDİĞİMİZ İCİN SADECE PROJECT NESNELERİNİ SAVE EDEREK DEV NESNELERİNİ DE KATIT ETMİŞ OLDUK.

//        session.save(dev1);
//        session.save(dev2);
//        session.save(dev3);
//        session.save(dev4);
//        session.save(dev5);

        tx.commit();
        session.close();
        sf.close();


    }
}
