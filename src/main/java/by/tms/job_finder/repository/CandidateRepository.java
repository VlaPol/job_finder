package by.tms.job_finder.repository;

import by.tms.job_finder.dto.CandidateDTO;
import by.tms.job_finder.entity.Candidate;

public interface CandidateRepository extends BaseRepository<Candidate, Long> {
    void saveCandidateWithCV(CandidateDTO candidate);
}
