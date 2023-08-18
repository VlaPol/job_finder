package by.tms.job_finder.repository;

import by.tms.job_finder.entity.Candidate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CandidateRepositoryImpl
        extends BaseRepositoryImpl<Candidate, Long>
        implements CandidateRepository {

    public CandidateRepositoryImpl() {
        super(Candidate.class);
    }

    @Override
    public Optional<Candidate> findCandidateByEmail(String email) {

        return entityManager.createQuery("""
                        SELECT candidate
                        FROM Candidate candidate
                        WHERE lower(candidate.email) = lower(:email)
                        """, Candidate.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }

}
