package io.glitchtech.decision.decision.messaging.event;


import io.glitchtech.decision.decision.dto.CustomerDTO;

import java.io.Serializable;
import java.time.Instant;

public sealed interface CustomerEvent extends Serializable {
    record CustomerCreated(Long customerId, Instant createdAt, CustomerDTO customerDTO) implements CustomerEvent {
    }
}
