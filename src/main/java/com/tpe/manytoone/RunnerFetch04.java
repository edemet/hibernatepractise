package com.tpe.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {


    public static void main(String[] args) {


        org.hibernate.cfg.Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer04.class).addAnnotatedClass(Company.class);// configürasyon olusturduk hibernate ve annote class ile birlikte
        SessionFactory sf=cfg.buildSessionFactory();// session olusturmak için kullanıyoruz.
        //conf dosyasını okur ve uygulama ile database arasında crud operasyonlarını yapmak için kullanıyoruz.
        Session session=sf.openSession();
        Transaction tx = session.beginTransaction(); // parcalanmayan atomik yapıdaki işlemler
        //buarada yapılan bir işlemde hata olursa diger işlemede devamn etmiyor.


        //1--id=2 olan developerın çalıştığı company bilgilerini getiriniz.


    //    Developer04 dev=session.get(Developer04.class,2);
     //   System.out.println(dev.getCompany());


        //

        //2--tüm developerların ismini ve çalıştığı company ismini görüntüleyiniz.

        String sql1="Select d.name,c.companyname from t_developer4 d inner join company c on d.company_id=c.id ";

        List<Object[]> resultList1=session.createSQLQuery(sql1).getResultList();

        for(Object[] r: resultList1){

            System.out.println(Arrays.toString(r));
        }

        //ödev ://3--Googleda çalışan developerların ismini ve branchini görüntüleyiniz.***ÖDEV***

        tx.commit();
        session.close();
        sf.close();
    }
}
