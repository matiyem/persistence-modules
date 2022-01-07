package com.example.hibernate.fetching.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * created by Atiye Mousavi
 * Date: 9/7/2021
 * Time: 8:50 AM
 */

public class HibernateUtil {

    //برای اینکه به کامپایلر بگوییم بعضی چیز ها نادیده بگیرد.دو تا از متداول ترین ها unchecked و depreaction است
    //از unchecked برای اینکه به کامپایلر بگوییم raw type ها را نادیده بگیرد
    //از deprecation برای انکه به کامپایلر اگر از تد های deprecate استفاده کرد این موضوع را نادیده بگیرد

    @SuppressWarnings("deprecation")
    public static Session getHibernateSession(String fetchMethod) {
        //یک sessionFactory یک interface  است. SessionFactory را می توان با ارائه آبجکت configuration ایجاد کرد ، که شامل تمام جزئیات و ویژگی DB مربوط به فایل hibernate.cfg.xml یا فایل hibernate.properties است. SessionFactory یک کارخانه برای آبجکت session است
        //ما می توانیم یک پیاده سازی SessionFactory در هر پایگاه داده در هر برنامه ایجاد کنیم. اگر برنامه شما به چندین پایگاه داده اشاره می کند ، باید در هر پایگاه داده یک SessionFactory ایجاد کنید.
        //هر sessionFactory یک heavyWeight است . معمولاً در هنگام راه اندازی برنامه ایجاد می شود و برای استفاده بعدی نگهداری می شود. SessionFactory یک thread safe است و توسط همه thread های یک برنامه استفاده میشود


        // two config files are there
        // one with lazy loading enabled
        // another lazy = false
        SessionFactory sf;
        if ("lazy".equals(fetchMethod)) {
            sf = new Configuration().configure("fetchingLazy.cfg.xml").buildSessionFactory();
        } else {
            sf = new Configuration().configure("fetching.cfg.xml").buildSessionFactory();
        }
        // fetching.cfg.xml is used for this example
        return sf.openSession();
    }

    public static Session getHibernateSession() {
        return new Configuration().configure("fetching.cfg.xml").buildSessionFactory().openSession();
    }
}
