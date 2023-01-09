package com.tpe.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {

    public static void main(String[] args) {


        Developer01 dev1=new Developer01();

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer01.class);// configürasyon olusturduk hibernate ve annote class ile birlikte
        SessionFactory sf=cfg.buildSessionFactory();// session olusturmak için kullanıyoruz.
        //conf dosyasını okur ve uygulama ile database arasında crud operasyonlarını yapmak için kullanıyoruz.
        Session session=sf.openSession();
        Transaction tx = session.beginTransaction(); // parcalanmayan atomik yapıdaki işlemler
        //buarada yapılan bir işlemde hata olursa diger işlemede devamn etmiyor.


        //get ile
//        dev1=session.get(Developer01.class,1);
//        System.out.println(dev1.toString());


        //sql ile tüm datayı cek yazdır.
//
//        String sql1="SELECT * FROM t_developer01";
//        List<Object[]> obj1=session.createSQLQuery(sql1).getResultList();
//        obj1.forEach(ob-> System.out.println(Arrays.toString(ob)));

        //hql ile tüm datayı alalım
//
//        String hql="FROM Developer01";
//        List<Developer01> obj2=session.createQuery(hql,Developer01.class).getResultList();
//        obj2.forEach(ob1-> System.out.println(ob1));
////
//        //2.yoll
//        String hql1="FROM Developer01";
//        List<Object> obj3=session.createQuery(hql1).getResultList();
//        obj3.forEach(ob1-> System.out.println(ob1));


        // hql ile ismi shrek olan datyı cekin

//        String hqlQuery2="FROM Developer01 WHERE name='Shrek'";
//        List<Developer01> resultList3=session.createQuery(hqlQuery2, Developer01.class).getResultList();
//        System.out.println("---HQL---");
//        for (Developer01 d: resultList3){
//            System.out.println(d.toString());
//        }

        //2.yoll / BURAYA BAKACAGIZ???
//        String hqlQuery2="FROM Developer01 WHERE name='Shrek'";
//        List<Object[]> resultList3=session.createQuery(hqlQuery2).getResultList();
//        resultList3.forEach(t-> System.out.println(Arrays.toString(t)));







        tx.commit(); // transaction'ı bunun ile kapatıyoruz. commit olmazsa save yapmaz..
        session.close();
        sf.close();
    }
}
