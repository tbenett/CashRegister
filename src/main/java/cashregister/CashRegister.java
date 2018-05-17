package cashregister;

class CashRegister {
    public Price total(Price price, Quantity quantity) {
        return price.multiplyBy(quantity);
    }
}
