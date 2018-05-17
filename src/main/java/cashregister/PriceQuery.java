package cashregister;

import java.util.Arrays;
import java.util.Collection;

class PriceQuery {

    private final Collection<ItemReference> itemReferences;

    PriceQuery(ItemReference... itemReferences) {
        this.itemReferences = Arrays.asList(itemReferences);
    }

    Result findPrice(String soughtItemCode) {

        for (ItemReference itemReference : itemReferences) {
            if (itemReference.matchesSoughtItemCode(soughtItemCode)) {
                return Result.found(itemReference.getUnitPrice());
            }
        }

        return Result.notFound(soughtItemCode);
    }
}
