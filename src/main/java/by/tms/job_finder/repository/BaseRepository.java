package by.tms.job_finder.repository;

import by.tms.job_finder.entity.Candidate;
import by.tms.job_finder.entity.Employer;

import java.util.Optional;

public interface BaseRepository<E, ID> {

    E getReferenceById(ID id);

    Optional<E> findById(ID id);

    Optional<Candidate> findCandidateByEmail(String email);

    Optional<Employer> findEmployerByEmail(String email);

    void create(E entity);

    void remove(ID id);
}
