package hotel.rating.system.service;

import hotel.rating.system.DAO.HotelRatingDao;
import hotel.rating.system.UI.DisplayHotelRatingService;
import hotel.rating.system.enums.HotelLabel;
import hotel.rating.system.enums.RatingRange;
import hotel.rating.system.models.Hotel;
import hotel.rating.system.utils.FilterHotelRating;

import java.util.*;

public class HotelRatingServiceImpl implements HotelRatingService{
    private HotelRatingDao hotelRatingDao;

    public HotelRatingServiceImpl(){
        this.hotelRatingDao = new HotelRatingDao();
    }

    @Override
    public void addUser(String userId) {
        this.hotelRatingDao.addUser(userId);
        System.out.println("New user added with userID" + userId);
    }

    @Override
    public void addHotel(int hotelId, String hotelName, int rating, HotelLabel hotelLabel, String desc) {
        Hotel hotel = new Hotel(hotelId, hotelName, rating, hotelLabel, desc);
        this.hotelRatingDao.addHotel(hotel);
    }

    @Override
    public void addRating(int rating, String userID, int hotelId, String review) {
        this.hotelRatingDao.addUser(userID);
        Hotel hotel = this.hotelRatingDao.getHotelById(hotelId);
        System.out.println("Rating has been added to the hotel");
    }

    @Override
    public void filterHotelByRating(RatingRange ratingRange) {
        HashMap<RatingRange, ArrayList<Hotel>> hotelsByRatingRange = this.hotelRatingDao.getRatingRangeArrayListHashMap();
        List<Hotel> hotelList = hotelsByRatingRange.get(ratingRange);
        System.out.println(hotelList);
    }

    @Override
    public void orderHotelByRating(RatingRange ratingRange) {
        HashMap<RatingRange, ArrayList<Hotel>> hotelsByRatingRange = this.hotelRatingDao.getRatingRangeArrayListHashMap();
        List<Hotel> hotelList = hotelsByRatingRange.get(ratingRange);
        Comparator<Hotel> hotelComparator = Comparator.comparingInt(Hotel::getHotelID).thenComparingInt(Hotel::getRating).reversed();
        Collections.sort(hotelList, hotelComparator);
        hotelList = FilterHotelRating.orderByLabelAndRating(hotelList);

        DisplayHotelRatingService.displayHotelInfo(hotelList);
    }

    @Override
    public void orderByRecentHotel() {
        ArrayList<Hotel> hotelArrayList = this.hotelRatingDao.viewRecentHotels();
        System.out.println("Recent Order list");
        System.out.println(hotelArrayList);
    }
}
