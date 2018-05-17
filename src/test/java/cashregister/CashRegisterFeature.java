package cashregister;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static cashregister.ItemReference.aReference;
import static org.assertj.core.api.Assertions.*;

class CashRegisterFeature {
    private CashRegister cashRegister;
    private PriceQuery priceQuery;

    @BeforeEach
    void setUp() {
        cashRegister = new CashRegister();
        priceQuery = new PriceQuery(
            aReference().withItemCode("APPLE").withUnitPrice(1.20).build(),
            aReference().withItemCode("BANANA").withUnitPrice(1.90).build()
        );
    }

    @Test
    public void calculateTotalPriceOfOneItemEqualsItemPrice() {
        CashRegister cashRegister = new CashRegister();
        final Price price = Price.valueOf(1.20);
        final Quantity quantity = Quantity.valueOf(1);
        final Price total = cashRegister.total(price, quantity);

        assertThat(total).isEqualTo(Price.valueOf(1.2));
    }

    @ParameterizedTest
    @CsvSource({
        "APPLE, 1, 1.20",
        "APPLE, 2, 1.20",
        "BANANA, 10, 1.90"
    })
    void total_is_product_of_quantity_by_item_price_corresponding_to_existing_item_code(String itemCode, double quantity, double unitPrice) {
        Result total = cashRegister.total(
            priceQuery.findPrice(itemCode),
            Quantity.valueOf(quantity)
        );

        assertThat(total).isEqualTo(Result.found(Price.valueOf(quantity * unitPrice)));
    }

    @Test
    void total_not_found_when_item_price_not_found() {
        Result total = cashRegister.total(
            priceQuery.findPrice("PEACH"),
            Quantity.valueOf(1)
        );

        assertThat(total).isEqualTo(Result.notFound("PEACH"));
    }
}