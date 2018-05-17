package cashregister;

class CashRegister {
    Price total(Price price, Quantity quantity) {
        return price.multiplyBy(quantity);
    }

    Result total(Result result, Quantity quantity) {
        return result.map(price -> price.multiplyBy(quantity));
    }
}
