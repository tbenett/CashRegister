package cashregister;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static cashregister.ItemReference.aReference;
import static org.assertj.core.api.Assertions.assertThat;

class PriceQueryTest {


    private PriceQuery priceQuery;

    @BeforeEach
    void setUp() {
        priceQuery = new PriceQuery(
            aReference().withItemCode("APPLE").withUnitPrice(1.20).build(),
            aReference().withItemCode("BANANA").withUnitPrice(1.90).build()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "APPLE, 1.20",
        "BANANA, 1.90"})
    void find_the_price_given_an_item_code(String itemCode, double unitPrice) {
        final Result total = priceQuery.findPrice(itemCode);

        assertThat(total).isEqualTo(Result.found(Price.valueOf(unitPrice)));

        total.ifFound(System.out::println);
    }

    @Test
    void search_an_unknown_item() {
        final Result total = priceQuery.findPrice("PEACH");

        assertThat(total).isEqualTo(Result.notFound("PEACH"));

        total.ifNotFound(System.out::println);
    }
}