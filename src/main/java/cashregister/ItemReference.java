package cashregister;

class ItemReference {
    private final String itemCode;
    private final Price unitPrice;

    private ItemReference(String itemCode, Price unitPrice) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
    }

    static Builder aReference() {
        return new Builder();
    }

    boolean matchesSoughtItemCode(String itemCode) {
        return this.itemCode.equals(itemCode);
    }

    Price getUnitPrice() {
        return unitPrice;
    }

    static final class Builder {
        private String itemCode;
        private Price unitPrice;

        private Builder() {}

        Builder withItemCode(String itemCode) {
            this.itemCode = itemCode;
            return this;
        }

        Builder withUnitPrice(Price unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        Builder withUnitPrice(double unitPrice) {
            this.unitPrice = Price.valueOf(unitPrice);
            return this;
        }

        ItemReference build() {
            return new ItemReference(itemCode, unitPrice);
        }
    }
}
