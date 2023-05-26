package hotel.rating.system.UI;

import hotel.rating.system.models.Hotel;

import java.util.List;

public class DisplayHotelRatingService {

    public static void displayHotelInfo(List<Hotel> hotelList){
        System.out.println("-------------Welcome to hotel review system -----------");
        System.out.println("Displaying hotel");
        for(Hotel hotel: hotelList){
            System.out.println(hotel);
        }
    }
}
