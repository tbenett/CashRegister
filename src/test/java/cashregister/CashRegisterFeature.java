package cashregister;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CashRegisterFeature {
    @Test
    public void calculateTotalPriceOfOneItemEqualsItemPrice() {
        CashRegister cashRegister = new CashRegister();
        final Price price = new Price(1.20);
        final double quantity = 1;
        final Price total = cashRegister.total(price, quantity);
        Assertions.assertThat(total).isEqualTo(new Price(1.2));
    }
}