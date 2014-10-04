package com.knowledgebase.company.tripadvisor.test;

import org.junit.Test;

import com.knowledgebase.company.tripadvisor.Coupon;
import com.knowledgebase.company.tripadvisor.CouponStore;

public class CouponStoreTest {

    @Test
    public void findBestCoupon() {
        CouponStore store = new CouponStore();
        Coupon coupon = store.findBestCoupon(100);
        if(coupon!=null) {
            System.out.println(coupon.subject);
            System.out.println(coupon.id);
        }
    }
    
    @Test
    public void findBestCoupon_with500() {
        CouponStore store = new CouponStore();
        Coupon coupon = store.findBestCoupon(500);
        if(coupon!=null) {
            System.out.println(coupon.subject);
            System.out.println(coupon.id);
        }
    }
    
    @Test
    public void findBestCoupon_with1000() {
        CouponStore store = new CouponStore();
        Coupon coupon = store.findBestCoupon(1000);
        if(coupon!=null) {
            System.out.println(coupon.subject);
            System.out.println(coupon.id);
        }
    }

}
