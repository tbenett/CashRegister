package cashregister;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CashRegisterFeature {
    @Test
    public void calculateTotalPriceOfOneItemEqualsItemPrice() {
        CashRegister cashRegister = new CashRegister();
        final Price price = Price.valueOf(1.20);
        final Quantity quantity = Quantity.valueOf(1);
        final Price total = cashRegister.total(price, quantity);

        assertThat(total).isEqualTo(Price.valueOf(1.2));
    }
}