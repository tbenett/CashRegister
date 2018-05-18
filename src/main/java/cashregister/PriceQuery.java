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
        return reduce(
            Result.notFound(soughtItemCode),
            (result, itemReference) -> {
                if (itemReference.matchesSoughtItemCode(soughtItemCode)) {
                    return Result.found(itemReference.getUnitPrice());
                } else {
                    return result;
                }
            }, itemReferences);
    }

    <R, T> R reduce(R identity, BiFunction<R, T, R> reducer, Iterable<T> items) {
        R accumulator = identity;

        for (T item : items) {
            accumulator = reducer.apply(accumulator, item);
        }

        return accumulator;
    }
}
