package hotel.rating.system.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private List<Hotel> hotelList;

    public String getUserId() {
        return userId;
    }

    public User(String userId) {
        this.userId = userId;
        this.hotelList = new ArrayList<>();
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }
}
