package io.glitchtech.decision.decision.messaging;

import io.glitchtech.decision.decision.domain.Decision;
import io.glitchtech.decision.decision.dto.CustomerDTO;
import io.glitchtech.decision.decision.messaging.event.CustomerEvent;
import io.glitchtech.decision.decision.service.DecisionMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerMessageHandler {
    private final DecisionMakerService decisionMakerService;

    //  @Bean
    //  public Consumer<CustomerEvent.CustomerCreated> handleCustomerCreated() {
    //       return this::handle; // return customerCreated -> handle(customerCreated);
    // }

    private void handle(CustomerEvent.CustomerCreated customerCreated) {
        log.info("Consuming the event: {}", customerCreated);
        CustomerDTO customerDTO = customerCreated.customerDTO();
        decisionMakerService.decide(customerDTO.ssn(), customerDTO.birthDate());
    }

    @Bean
    public Function<CustomerEvent.CustomerCreated, Decision> processCustomerCreated() {
        return customerCreated -> {
            log.info("Processing(transforming) the customer created: {}", customerCreated);
            CustomerDTO customerDTO = customerCreated.customerDTO();
            Decision decision = decisionMakerService.decide(customerDTO.ssn(), customerDTO.birthDate());
            log.info("Producing the event decision: {}", decision);
            return decision;
        };
    }
}
