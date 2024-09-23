package io.glitchtech.decision.decision.service;

import io.glitchtech.decision.decision.domain.Decision;
import io.glitchtech.decision.decision.repository.DecisionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class DecisionMakerServiceImpl implements DecisionMakerService {
    private final DecisionRepository decisionRepository;

    @Override
    public Decision decide(Integer ssn, LocalDate birthDate) {
        Decision decision = Decision.decide(ssn, birthDate);
        Decision decisionCreated = decisionRepository.save(decision);
        log.info("The credit application decision is: {}", decisionCreated.getCreditDecision());
        return decision;
    }
}
