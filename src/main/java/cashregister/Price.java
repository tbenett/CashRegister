package cashregister;

class Price {

    private final double price;

    public Price(double price) {
        this.price = price;
    }

    public Price multiplyBy(double factor) {
        return new Price(price * factor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price1 = (Price) o;

        return Double.compare(price1.price, price) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(price);
        return (int) (temp ^ (temp >>> 32));
    }
}
