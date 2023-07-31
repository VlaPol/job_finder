package by.tms.job_finder.repository;

import by.tms.job_finder.dto.CandidateDTO;
import by.tms.job_finder.entity.Candidate;
import by.tms.job_finder.entity.Cv;
import org.springframework.stereotype.Repository;

@Repository
public class CandidateRepositoryImpl
        extends BaseRepositoryImpl<Candidate, Long>
        implements CandidateRepository {

    public CandidateRepositoryImpl() {
        super(Candidate.class);
    }

    @Override
    public void saveCandidateWithCV(CandidateDTO entity) {
        Candidate candidate = entity.getCandidate();
        entityManager.persist(candidate);
        entityManager.flush();

        Long id = candidate.getId();

        Cv cv = new Cv();
        cv.setCandidateId(id);
        cv.setCandidate(candidate);
        cv.setContent(entity.getCvContent());

        entityManager.persist(cv);
    }
}
