package cashregister;

class Price {

    private final double value;

    private Price(double value) {
        this.value = value;
    }

    static Price valueOf(double value) {
        return new Price(value);
    }

    Price multiplyBy(double factor) {
        return valueOf(value * factor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price1 = (Price) o;

        return Double.compare(price1.value, value) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(value);
        return (int) (temp ^ (temp >>> 32));
    }
}
