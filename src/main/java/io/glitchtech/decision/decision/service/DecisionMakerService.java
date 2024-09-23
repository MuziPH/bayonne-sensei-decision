package io.glitchtech.decision.decision.service;

import io.glitchtech.decision.decision.domain.Decision;

import java.time.LocalDate;

public interface DecisionMakerService {
    Decision decide(Integer ssn, LocalDate birthDate);
}
