package by.tms.job_finder.repository;

import by.tms.job_finder.entity.Candidate;

import java.util.Optional;

public interface CandidateRepository extends BaseRepository<Candidate, Long> {
    Optional<Candidate> findCandidateByEmail(String email);
}
