package by.tms.job_finder.repository;

import by.tms.job_finder.entity.Candidate;
import by.tms.job_finder.entity.Employer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseRepositoryImpl<E, ID> implements BaseRepository<E, ID> {

    @PersistenceContext
    protected EntityManager entityManager;
    private CandidateRepository candidateRepository;
    private EmployerRepository employerRepository;
    private final Class<E> entityClass;

    @Override
    public E getReferenceById(ID id) {
        return entityManager.getReference(entityClass, id);
    }

    @Override
    public Optional<E> findById(ID id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    @Override
    public Optional<Candidate> findCandidateByEmail(String email) {
        return Optional.ofNullable(candidateRepository.findCandidateByEmail(email)).get();
    }

    @Override
    public Optional<Employer> findEmployerByEmail(String email) {
        return Optional.ofNullable(employerRepository.findEmployerByEmail(email)).get();
    }

    @Override
    public void create(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public void remove(ID id) {
        E tmpEntity = entityManager.find(entityClass, id);
        entityManager.remove(tmpEntity);
    }


}
