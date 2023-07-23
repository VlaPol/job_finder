package by.tms.job_finder.repository;

import by.tms.job_finder.entity.Candidate;
import org.springframework.stereotype.Repository;

@Repository
public class CandidateRepositoryImpl
        extends BaseRepositoryImpl<Candidate, Long>
        implements CandidateRepository {

    public CandidateRepositoryImpl() {
        super(Candidate.class);
    }
}
