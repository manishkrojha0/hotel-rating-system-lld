package hotel.rating.system.Exceptions;

public class HotelNotFound extends RuntimeException{
    public HotelNotFound(String message){
        super(message);
    }
}
