/**
 * @author Omar Bashir
 */
package bootcamp.kata.data;

import java.math.BigDecimal;

public class Results {
    private final BigDecimal sum;
    private final BigDecimal difference ;
    private final BigDecimal product;
    private final BigDecimal quotient;

    public Results(BigDecimal sum, BigDecimal difference, BigDecimal product, BigDecimal quotient) {
        this.sum = sum;
        this.difference = difference;
        this.product = product;
        this.quotient = quotient;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public BigDecimal getDifference() {
        return difference;
    }

    public BigDecimal getProduct() {
        return product;
    }

    public BigDecimal getQuotient() {
        return quotient;
    }
}
