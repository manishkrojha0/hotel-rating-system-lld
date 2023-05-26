package hotel.rating.system.service;

import hotel.rating.system.enums.HotelLabel;
import hotel.rating.system.enums.RatingRange;

public interface HotelRatingService {
    // register the user into the system.
    public void addUser(String userId);
    // add hotel
    public void addHotel(int hotelId, String hotelName, int rating, HotelLabel hotelLabel, String desc);

    // add rating
    public void addRating(int rating, String userID, int hotelId, String review);

    // filter the rating on the basis of rating range
    public void filterHotelByRating(RatingRange ratingRange);

    // order the hotel by rating
    public void orderHotelByRating(RatingRange ratingRange);

    // order the hotel by recent hotel
    public void orderByRecentHotel();

    //

}
