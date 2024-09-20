package io.glitchtech.decision.decision.domain;

import io.glitchtech.decision.decision.enumerated.CreditDecision;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Decision {
    private static final Logger log = LoggerFactory.getLogger(Decision.class);
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private CreditDecision creditDecision;
    private Integer ssn;

    public Decision(CreditDecision creditDecision, Integer ssn) {
        this.creditDecision = creditDecision;
        this.ssn = ssn;
    }

    public static Decision decide(Integer ssn, LocalDate birthDate) {
        // Credit repayment term is 40 years
        int loanTerm = 20;
        int ageLimit = 70;
        // Reject is customer is over 70 years after term of loan
        // customer age + 40 < 70
        long currentAge = ChronoUnit.YEARS.between(birthDate, LocalDate.now());

        log.info("Current Age: {}. Age at term end: {}", currentAge, (currentAge + loanTerm));

        if (ssn % 2 == 0) {
            log.info("Pre-Approved on office");
            return new Decision(CreditDecision.PRE_APPROVED, ssn);
        } else if (currentAge + loanTerm > ageLimit) {
            log.info("Rejected on age limit");
            return new Decision(CreditDecision.REJECTED, ssn);
        } else {
            log.info("Approved on age limit");
            return new Decision(CreditDecision.APPROVED, ssn);
        }
    }
}
