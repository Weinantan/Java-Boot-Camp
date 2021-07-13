/**
 * @author Omar Bashir
 */
package bootcamp.kata.process;

import bootcamp.kata.data.Params;
import bootcamp.kata.data.Results;

public class Processor {
    public Results process(final Params params) {
        var x = params.getX();
        var y = params.getY();
        return new Results(x.add(y),x.subtract(y),x.multiply(y),x.divide(y));
    }
}
