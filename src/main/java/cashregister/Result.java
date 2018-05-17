package cashregister;

import java.util.function.UnaryOperator;

abstract class Result {
    static Result found(Price price) {
        return new Found(price);
    }

    static Result notFound(String invalidItemCode) {
        return new NotFound(invalidItemCode);
    }

    abstract Result map(UnaryOperator<Price> f);

    private static class Found extends Result {
        private final Price price;

        private Found(Price price) {
            this.price = price;
        }

        @Override
        Result map(UnaryOperator<Price> f) {
            return found(f.apply(price));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Found found = (Found) o;

            return price != null ? price.equals(found.price) : found.price == null;
        }

        @Override
        public int hashCode() {
            return price != null ? price.hashCode() : 0;
        }
    }

    private static class NotFound extends Result {
        private final String invalidItemCode;

        private NotFound(String invalidItemCode) {
            this.invalidItemCode = invalidItemCode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            NotFound notFound = (NotFound) o;

            return invalidItemCode != null ? invalidItemCode.equals(notFound.invalidItemCode) : notFound.invalidItemCode == null;
        }

        @Override
        public int hashCode() {
            return invalidItemCode != null ? invalidItemCode.hashCode() : 0;
        }

        @Override
        Result map(UnaryOperator<Price> f) {
            return this;
        }
    }
}
