package cashregister;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

class PriceQuery {

    private final Collection<ItemReference> itemReferences;

    PriceQuery(ItemReference... itemReferences) {
        this.itemReferences = Arrays.asList(itemReferences);
    }

    Result findPrice(String soughtItemCode) {
        return itemReferences
            .stream()
            .filter(item -> item.matchesSoughtItemCode(soughtItemCode))
            .map(ItemReference::getUnitPrice)
            .map(Result::found)
            .findFirst()
            .orElseGet(() -> Result.notFound(soughtItemCode));
    }
}
