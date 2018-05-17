package cashregister;

import java.util.Arrays;
import java.util.Collection;

class PriceQuery {

    private final Collection<Reference> references;

    PriceQuery(Reference... references) {
        this.references = Arrays.asList(references);
    }

    Price findPrice(String itemCode) {

        for (Reference reference : references) {
            if (reference.hasSameItemCodeAs(itemCode)) {
                return reference.getUnitPrice();
            }
        }

        throw  new UnsupportedOperationException();
    }
}
