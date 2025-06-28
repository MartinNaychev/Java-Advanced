package WorkingWithAbstraction.HotelReservation;

public enum DiscountType {
    VIP(0.8),
    SecondVisit(0.9),
    NONE(1);


    private double percent;

    DiscountType(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return this.percent;
    }
}
