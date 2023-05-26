package hotel.rating.system.models;

import hotel.rating.system.enums.HotelLabel;
import hotel.rating.system.enums.RatingRange;

public class Hotel {
    private int hotelID;
    private String hotelName;
    private RatingRange ratingRange;
    private int rating;
    private HotelLabel hotelLabel;
    private String reviewDescription;

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelID=" + hotelID +
                ", hotelName='" + hotelName + '\'' +
                ", ratingRange=" + ratingRange +
                ", rating=" + rating +
                ", hotelLabel=" + hotelLabel +
                ", reviewDescription='" + reviewDescription + '\'' +
                '}';
    }

    public Hotel(int hotelID, String hotelName, int rating, HotelLabel hotelLabel, String reviewDescription) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.rating = rating;
        this.hotelLabel = hotelLabel;
        this.reviewDescription = reviewDescription;
        this.ratingRange = this.ratingRangeByRating(rating);
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public RatingRange getRatingRange() {
        return ratingRange;
    }

    public void setRatingRange(RatingRange ratingRange) {
        this.ratingRange = ratingRange;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public HotelLabel getHotelLabel() {
        return hotelLabel;
    }

    public void setHotelLabel(HotelLabel hotelLabel) {
        this.hotelLabel = hotelLabel;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public RatingRange ratingRangeByRating(int rating){
        if(rating<3){
            this.setRatingRange(RatingRange.LOWER_RANGE);
            return RatingRange.LOWER_RANGE;
        }
        else if(rating<4){
            this.setRatingRange(RatingRange.MEDIUM_RANGE);
            return RatingRange.MEDIUM_RANGE;
        }
        else{
            this.setRatingRange(RatingRange.HIGH_RANGE);
            return RatingRange.HIGH_RANGE;
        }
    }
}
