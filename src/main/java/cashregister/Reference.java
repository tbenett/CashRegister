package cashregister;

class Reference {
    private final String itemCode;
    private final Price unitPrice;

    private Reference(String itemCode, Price unitPrice) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
    }

    static Builder aReference(){
        return new Builder();
    }

    boolean hasSameItemCodeAs(String itemCode) {
        return this.itemCode.equals(itemCode);
    }

    Price getUnitPrice() {
        return unitPrice;
    }

    public static class Builder {
        private String itemCode;
        private Price unitPrice;

        Builder withItemCode(String itemCode) {
            this.itemCode = itemCode;
            return this;
        }

        public Builder withUnitPrice(Price unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        Builder withUnitPrice(double unitPrice) {
            this.unitPrice = Price.valueOf(unitPrice);
            return this;
        }

        Reference build() {
            return new Reference(itemCode, unitPrice);
        }
    }
}
