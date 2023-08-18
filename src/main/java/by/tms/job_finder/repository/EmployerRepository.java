package by.tms.job_finder.repository;

import by.tms.job_finder.entity.Employer;

import java.util.Optional;

public interface EmployerRepository extends BaseRepository<Employer, Long> {
    Optional<Employer> findemployerByEmail(String email);
}
