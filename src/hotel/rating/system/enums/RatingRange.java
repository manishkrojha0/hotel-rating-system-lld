package hotel.rating.system.enums;

public enum RatingRange {
    LOWER_RANGE(1, 2),
    MEDIUM_RANGE(3,4),
    HIGH_RANGE(5);
    private final int low;
    private final int high;
    private RatingRange(int low, int high){
        this.low = low;
        this.high = high;
    }
    private RatingRange(int high){
        this.low = high;
        this.high = high;
    }
}
