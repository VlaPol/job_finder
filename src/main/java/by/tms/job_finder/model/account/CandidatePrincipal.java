package by.tms.job_finder.model.account;

import by.tms.job_finder.entity.Candidate;
import lombok.Value;

import java.util.UUID;

@Value
public class CandidatePrincipal implements PrincipalObject {
    Long id;
    String email;

    public static CandidatePrincipal from(Candidate candidate) {
        return new CandidatePrincipal(candidate.getId(), candidate.getEmail());
    }

    @Override
    public AccountRole getRole() {
        return AccountRole.CANDIDATE;
    }
}
