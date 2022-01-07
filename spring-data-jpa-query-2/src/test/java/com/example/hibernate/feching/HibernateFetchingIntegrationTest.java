package com.example.hibernate.feching;

import com.example.hibernate.fetching.model.OrderDetail;
import com.example.hibernate.fetching.view.FetchingAppView;
import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * created by Atiye Mousavi
 * Date: 9/7/2021
 * Time: 12:12 PM
 */

public class HibernateFetchingIntegrationTest {

    @Before
    public void addFecthingTestData() {
        FetchingAppView fav = new FetchingAppView();
        fav.createTestData();
    }

    // testLazyFetching() tests the lazy loading
    // Since it lazily loaded so orderDetalSetLazy won't
    // be initialized
    @Test
    public void testLazyFetching() {
        FetchingAppView fav = new FetchingAppView();
        Set<OrderDetail> orderDetailSetLazy = fav.lazyLoaded();
        //این خط  رو بذاریم این تست به پایان میرسد .چون مقداری که داخل پرانتز برمیگرداند مقدار true است
        //در اصل این تست آخری است که اجرا میشود
        assertFalse(Hibernate.isInitialized(orderDetailSetLazy));
        //اگر این خط را بگذاریم این تست به پایان نمیرسد چون مقدار داخل پرانتز هم true است
//        assertTrue(Hibernate.isInitialized(orderDetailSetLazy));
    }

    @Test
    public void testEagerFetching() {
        FetchingAppView fav = new FetchingAppView();
        Set<OrderDetail> orderDetailSetEager = fav.eagerLoaded();
        assertTrue(Hibernate.isInitialized(orderDetailSetEager));


    }
}
