package io.glitchtech.decision.decision.domain;

import io.glitchtech.decision.decision.enumerated.CreditDecision;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class DecisionTest {
    @Test
    void shouldRejectIfCustomerIsOverSeventyAfterCreditTerm() {
        // Given
        Integer ssn = 19785421;
        LocalDate birthDate = LocalDate.of(1978, Month.NOVEMBER, 17);
        // When
        Decision decision = Decision.decide(ssn, birthDate);
        // Then
        Assertions.assertEquals(CreditDecision.APPROVED, decision.getCreditDecision());

    }

    @Test
    void shouldApproveIfCustomerIdIsEven() {
        // Given
        Integer ssn = 19920222;
        LocalDate birthDate = LocalDate.of(1992, Month.FEBRUARY, 22);
        // When
        Decision decision = Decision.decide(ssn, birthDate);
        // Then
        Assertions.assertEquals(CreditDecision.PRE_APPROVED, decision.getCreditDecision());
    }

}