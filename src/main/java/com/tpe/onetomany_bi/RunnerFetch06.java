package com.tpe.onetomany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch06 {


    public static void main(String[] args) {


        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer06.class).addAnnotatedClass(Company3.class);// configürasyon olusturduk hibernate ve annote class ile birlikte
        SessionFactory sf=cfg.buildSessionFactory();// session olusturmak için kullanıyoruz.
        //conf dosyasını okur ve uygulama ile database arasında crud operasyonlarını yapmak için kullanıyoruz.
        Session session=sf.openSession();
        Transaction tx = session.beginTransaction(); // parcalanmayan atomik yapıdaki işlemler
        //buarada yapılan bir işlemde hata olursa diger işlemede devamn etmiyor.

        //1--Amazonda çalışan developer bilgilerini getiriniz.

        String hql="FROM Company3 c WHERE c.company";


        //2--"Gandalf"ın çalıştığı company bilgilerini getiriniz.

        String hql2="FROM Developer06 d WHERE d.name='Gandalf'";
        Developer06 dev=session.createQuery(hql2,Developer06.class).uniqueResult();
        System.out.println(dev.getCompany());

        //------------------------------------------Delete - - OrphanRemoval -- CascadeTypeALL-----------------------

        ////3--id=22 olan companynin dev listesinden id=3 olan developerı siliniz.

//        Developer06 dev3=session.get(Developer06.class,3L);
//        Company3 company=session.get(Company3.class,22L);
//
//         company.getDevs().remove(dev3); // İD'Sİ 3 OLAN DEV'İ ID'Sİ 22 OLAN COMPANY'DEN SİLDİK.
//
//        System.out.println(company.getDevs());// //ıd=22 olan company'nin silme işleminden sonra dev listesini yazdırdık kontrol için


        /////4--id 22 olan company i sil

        Company3 company2=session.get(Company3.class,22L);
        session.delete(company2); //orphanremoval == true ise hem listeden hemde tablodan siler
        //Cascade Type=all ise de sadece listeden cıkarır tablodan silmez

        tx.commit();
        session.close();
        sf.close();
    }
}
