package hotel.rating.system.utils;

import hotel.rating.system.enums.HotelLabel;
import hotel.rating.system.enums.RatingRange;
import hotel.rating.system.models.Hotel;

import java.util.ArrayList;
import java.util.List;

public class FilterHotelRating {

    public static List<Hotel> orderByLabelAndRating(List<Hotel> hotelList){
        List<Hotel> orderedList = new ArrayList<>();
        for(Hotel hotel: hotelList){
            if(hotel.getHotelLabel() == HotelLabel.PLUS_HOTEL){
                orderedList.add(hotel);
            }
        }
        for(Hotel hotel: hotelList){
            if(hotel.getHotelLabel() != HotelLabel.PLUS_HOTEL){
                orderedList.add(hotel);
            }
        }

        return orderedList;

    }
}
