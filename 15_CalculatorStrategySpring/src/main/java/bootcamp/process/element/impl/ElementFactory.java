package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

// TODO this is a configuration class.
// TODO this needs to scan components in the relevant package(s).
// TODO factory methods to be annotated as Bean


@ComponentScan
@Configuration
public class ElementFactory {

    @Bean
    ProcessingElement adder() {
        return BigDecimal::add;
    }

    @Bean
    ProcessingElement subtractor() {
        return BigDecimal::subtract;
    }

    @Bean
    ProcessingElement multiplier() {
        return BigDecimal::multiply;
    }

    @Bean
    ProcessingElement divider() {
        return BigDecimal::divide;
    }
}
