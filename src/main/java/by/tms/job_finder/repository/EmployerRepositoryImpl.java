package by.tms.job_finder.repository;

import by.tms.job_finder.entity.Employer;
import org.springframework.stereotype.Repository;

@Repository
public class EmployerRepositoryImpl
        extends BaseRepositoryImpl<Employer, Long>
        implements EmployerRepository {

    public EmployerRepositoryImpl() {
        super(Employer.class);
    }
}
