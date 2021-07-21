package bootcamp.process.element.impl;
import bootcamp.process.element.ProcessingElement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;

// TODO this is a configuration class.
// TODO this needs to scan components in the relevant package(s).
// TODO factory methods to be annotated as Bean

@ComponentScan(basePackages =  "bootcamp.process.calculator")
public class ElementFactory {
    @Bean
    public ProcessingElement adder() {
        return BigDecimal::add;
    }

    @Bean
    public ProcessingElement subtractor() {
        return BigDecimal::subtract;
    }

    @Bean
    public ProcessingElement multiplier() {
        return BigDecimal::multiply;
    }

    @Bean
    public ProcessingElement divider() {
        return BigDecimal::divide;
    }
}
