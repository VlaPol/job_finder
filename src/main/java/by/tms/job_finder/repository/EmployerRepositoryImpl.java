package by.tms.job_finder.repository;

import by.tms.job_finder.entity.Employer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmployerRepositoryImpl
        extends BaseRepositoryImpl<Employer, Long>
        implements EmployerRepository {

    public EmployerRepositoryImpl() {
        super(Employer.class);
    }

    @Override
    public Optional<Employer> findemployerByEmail(String email) {
        return entityManager.createQuery("""
                        SELECT employer
                        FROM Employer employer
                        WHERE lower(employer.email) = lower(:email)
                        """, Employer.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
}
