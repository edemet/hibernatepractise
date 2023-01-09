package com.tpe.onetomany_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05 {


    public static void main(String[] args) {


        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer05.class).addAnnotatedClass(Company2.class);// configürasyon olusturduk hibernate ve annote class ile birlikte
        SessionFactory sf=cfg.buildSessionFactory();// session olusturmak için kullanıyoruz.
        //conf dosyasını okur ve uygulama ile database arasında crud operasyonlarını yapmak için kullanıyoruz.
        Session session=sf.openSession();
        Transaction tx = session.beginTransaction(); // parcalanmayan atomik yapıdaki işlemler
        //buarada yapılan bir işlemde hata olursa diger işlemede devamn etmiyor.

        //1--Amazonda çalışan developer bilgilerini getiriniz.

        String hql1="FROM Company2 c WHERE c.companyname='Amazon'";
        Company2 company=session.createQuery(hql1,Company2.class).uniqueResult();
        System.out.println("******** Amazonda Calisanlarr *************");
        company.getDevs().forEach(System.out::println);

        //2.yoll

        System.out.println("******** Amazonda Calisanlarr 2. çözümm *************");
        String hql2="Select c.devs FROM Company2 c WHERE c.companyname='Amazon'";
        List<Object> resultList1=session.createQuery(hql2).getResultList();
        resultList1.forEach(System.out::println);



        tx.commit();
        session.close();
        sf.close();
    }
}
