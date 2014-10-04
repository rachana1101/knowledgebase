package com.knowledgebase.company.tripadvisor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Location {
    int locationId;
    int parentLocationId; // -1 if no parent, location is hierarchy
    String name;

    public Location(int locationId, int parentLocationId, String name) {
        this.locationId = locationId;
        this.parentLocationId = parentLocationId;
        this.name = name;
    }

    static Location findLocation(int locationId) {
        if (locationId == 100) {
            return new Location(100, 200, "CA");
        }
        if (locationId == 200) {
            return new Location(200, 400, "XYZ");
        }
        if (locationId == 500) {
            return new Location(500, 800, "XYZ");
        }
        if(locationId == 800) {
            return new Location(800, 400, "XYZ");
        }
        if (locationId == 400) {
            return new Location(400, -1, "XYZ");
        }
        if (locationId == 1000) {
            return new Location(1000, -1, "XYZ");
        }
        return null;
    }
}

public class CouponStore {

    private List<Coupon> couponList = createCoupons(); // already populated,
                                                       // static
    private HashMap<Integer, Coupon> couponMap; // O(1)

    // Return null if no coupon
    public Coupon findBestCoupon(int locationId) {
        if (locationId == -1) {
            return null;
        } else {
            Location location = Location.findLocation(locationId);
            
            for (Coupon coupon : couponList) {
                // exact matching for the location specified
                if (coupon.locationId == locationId) {
                    return coupon;
                }
            }
           return findBestCoupon(location.parentLocationId);
        }
    }

    public List<Coupon> createCoupons() {
        List<Coupon> coupons = new ArrayList<Coupon>();
        coupons.add(new Coupon(1, "Spa", " spa ", 100));
        coupons.add(new Coupon(1, "Flea market coupon", " spa ", 200));
        coupons.add(new Coupon(1, "fish market ", " spa ", 400));
        return coupons;
    }

}
