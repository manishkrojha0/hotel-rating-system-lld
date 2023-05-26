package hotel.rating.system;

import hotel.rating.system.enums.HotelLabel;
import hotel.rating.system.enums.RatingRange;
import hotel.rating.system.service.HotelRatingService;
import hotel.rating.system.service.HotelRatingServiceImpl;

public class HotelRatingSystemApplication {
    public static void main(String[] args) {
        HotelRatingService hotelRatingService = new HotelRatingServiceImpl();
        // add user to the system
        hotelRatingService.addUser("testUser1");
        // add hotel to the system
        hotelRatingService.addHotel(1,"Grand Taj", 4, HotelLabel.PLUS_HOTEL, "Near the city");
        // add rating to the hotel
        hotelRatingService.addRating(4, "testUser1", 1, "Good hotel");
        // filter hotel by rating
        hotelRatingService.filterHotelByRating(RatingRange.HIGH_RANGE);
        // sort by rating
        hotelRatingService.orderHotelByRating(RatingRange.HIGH_RANGE);
        // order by recent
        hotelRatingService.orderByRecentHotel();
    }
}
