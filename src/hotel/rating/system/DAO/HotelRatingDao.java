package hotel.rating.system.DAO;

import hotel.rating.system.Exceptions.HotelNotFound;
import hotel.rating.system.enums.HotelLabel;
import hotel.rating.system.enums.RatingRange;
import hotel.rating.system.models.Hotel;

import java.util.ArrayList;
import java.util.HashMap;


public class HotelRatingDao {
    private HashMap<String , ArrayList<Hotel>> userHotelMap;
    private HashMap<Integer, ArrayList<Integer>> hotelRatingMap;
    private HashMap<RatingRange, ArrayList<Hotel>> ratingRangeArrayListHashMap;
    private HashMap<Integer, Hotel> idHotelMap;

    public HashMap<Integer, Hotel> getIdHotelMap() {
        return idHotelMap;
    }

    public void setIdHotelMap(HashMap<Integer, Hotel> idHotelMap) {
        this.idHotelMap = idHotelMap;
    }

    private String currentUserId;

    public HotelRatingDao(){
        this.userHotelMap = new HashMap<>();
        this.hotelRatingMap = new HashMap<>();
        this.ratingRangeArrayListHashMap = new HashMap<>();
        this.idHotelMap = new HashMap<>();
    }

    public void addUser(String currentUserId){
        this.currentUserId = currentUserId;
    }

    public void addHotel(Hotel hotel){
        if(!userHotelMap.containsKey(currentUserId)){
            userHotelMap.put(currentUserId, new ArrayList<>());
        }
        if(!ratingRangeArrayListHashMap.containsKey(hotel.getRatingRange())){
            ratingRangeArrayListHashMap.put(hotel.getRatingRange(), new ArrayList<>());
        }
        if(!hotelRatingMap.containsKey(hotel.getHotelID())){
            hotelRatingMap.put(hotel.getHotelID(), new ArrayList<>());
        }
        userHotelMap.get(currentUserId).add(hotel);
        ratingRangeArrayListHashMap.get(hotel.getRatingRange()).add(hotel);
        hotelRatingMap.get(hotel.getHotelID()).add(hotel.getRating());
        this.idHotelMap.put(hotel.getHotelID(), hotel);
    }

    public Hotel getHotelById(int hotelId){

        if(!idHotelMap.containsKey(hotelId)){
            throw new HotelNotFound("Hotel is not present with this id");
        }
        if(!userHotelMap.containsKey(currentUserId)){
            userHotelMap.put(currentUserId, new ArrayList<>());
        }
        this.userHotelMap.get(currentUserId).add(idHotelMap.get(hotelId));
        return idHotelMap.get(hotelId);
    }

    public ArrayList<Hotel> viewRecentHotels(){
        return this.userHotelMap.get(currentUserId);
    }

    public HashMap<RatingRange, ArrayList<Hotel>> getRatingRangeArrayListHashMap() {
        return ratingRangeArrayListHashMap;
    }

    public void setRatingRangeArrayListHashMap(HashMap<RatingRange, ArrayList<Hotel>> ratingRangeArrayListHashMap) {
        this.ratingRangeArrayListHashMap = ratingRangeArrayListHashMap;
    }

    public HashMap<String, ArrayList<Hotel>> getUserHotelMap() {
        return userHotelMap;
    }

    public void setUserHotelMap(HashMap<String, ArrayList<Hotel>> userHotelMap) {
        this.userHotelMap = userHotelMap;
    }

    public HashMap<Integer, ArrayList<Integer>> getHotelRatingMap() {
        return hotelRatingMap;
    }

    public void setHotelRatingMap(HashMap<Integer, ArrayList<Integer>> hotelRatingMap) {
        this.hotelRatingMap = hotelRatingMap;
    }

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }
}
