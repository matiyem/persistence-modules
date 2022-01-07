package com.example.hibernate.fetching.view;

import com.example.hibernate.fetching.model.OrderDetail;
import com.example.hibernate.fetching.model.UserEager;
import com.example.hibernate.fetching.model.UserLazy;
import com.example.hibernate.fetching.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.collection.internal.PersistentList;
import org.hibernate.collection.internal.PersistentSet;

import java.util.List;
import java.util.Set;

/**
 * created by Atiye Mousavi
 * Date: 9/7/2021
 * Time: 9:10 AM
 */

public class FetchingAppView {

    public FetchingAppView(){

    }
    // lazily loaded
    public Set<OrderDetail> lazyLoaded(){
        //LAZY on the other hand means that the contents of the List are fetched only when you try to access them.
        // For example, by calling course.getStudents().iterator(). Calling any access method on the List will initiate a
        // call to the database to retrieve the elements. This is implemented by creating a Proxy around the List (or Set).
        // So for your lazy collections, the concrete types are not ArrayList and HashSet, but PersistentSet and
        // PersistentList (or PersistentBag)
        final Session sessionLazy= HibernateUtil.getHibernateSession("lazy");
        //هم میتونیم کوییری ره بصورت کامل نوشت هم میتوان قسمت select * را ننوشت
        PersistentSet users1= (PersistentSet) sessionLazy.createQuery("From UserLazy").list();
        List<UserLazy> users=sessionLazy.createQuery("From UserLazy").list();
        users.forEach(user ->{
            System.out.println("lazyLoaded----------------"+user);
        });
        UserLazy userLazyLoaded=users.get(0);
        System.out.println(userLazyLoaded.getOrderDetail());


        // since data is lazyloaded so data won't be initialized
        return (userLazyLoaded.getOrderDetail());
    }

    // eagerly loaded
    public Set<OrderDetail> eagerLoaded(){
        //EAGER loading of collections means that they are fetched fully at the time their parent is fetched.
        // So if you have Course and it has List<Student>, all the students are fetched from the database at
        // the time the Course is fetched.
        final Session sessionEager = HibernateUtil.getHibernateSession();
        // data should be loaded in the following line
        // also note the queries generated
        List<UserEager> user=sessionEager.createQuery("From UserEager").list();
        user.forEach(users ->{
            System.out.println("EagerLoaded----------------"+users);
        });
        UserEager userEagerLoaded=user.get(0);
        System.out.println(userEagerLoaded.getOrderDetail());
        return userEagerLoaded.getOrderDetail();
    }
    // creates test data
    // call this method to create the data in the database
    public void createTestData(){
        final Session session=HibernateUtil.getHibernateSession("lazy");
        Transaction tx = session.beginTransaction();
        final UserLazy user1 = new UserLazy();
        final UserLazy user2 = new UserLazy();
        final UserLazy user3 = new UserLazy();

        session.save(user1);
        session.save(user2);
        session.save(user3);

        final OrderDetail order1 = new OrderDetail();
        final OrderDetail order2 = new OrderDetail();
        final OrderDetail order3 = new OrderDetail();
        final OrderDetail order4 = new OrderDetail();
        final OrderDetail order5 = new OrderDetail();

        session.saveOrUpdate(order1);
        session.saveOrUpdate(order2);
        session.saveOrUpdate(order3);
        session.saveOrUpdate(order4);
        session.saveOrUpdate(order5);

        tx.commit();
        session.close();
    }

}
