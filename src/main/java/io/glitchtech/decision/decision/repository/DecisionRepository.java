package io.glitchtech.decision.decision.repository;

import io.glitchtech.decision.decision.domain.Decision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecisionRepository extends JpaRepository<Decision, Long> {
}
