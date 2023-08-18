package by.tms.job_finder.model.account;

import by.tms.job_finder.entity.Candidate;
import by.tms.job_finder.entity.Employer;
import lombok.Value;

@Value
public class EmployerPrincipal implements PrincipalObject{
    Long id;
    String email;

    public static EmployerPrincipal from(Employer employer) {
        return new EmployerPrincipal(employer.getId(), employer.getEmail());
    }

    @Override
    public AccountRole getRole() {
        return AccountRole.EMPLOYER;
    }
}
