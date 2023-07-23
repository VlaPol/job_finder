package by.tms.job_finder.repository;

import by.tms.job_finder.entity.Vacancy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VacancyRepositoryImpl
        extends BaseRepositoryImpl<Vacancy, Long>
        implements VacancyRepository {

    public VacancyRepositoryImpl() {
        super(Vacancy.class);
    }

    @Override
    public List<Vacancy> findPageByEmployer(long employerId, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT opportunity
                        FROM Vacancy opportunity
                        WHERE opportunity.employer.id = :employerId
                        ORDER BY opportunity.createdAt DESC
                        """, Vacancy.class)
                .setParameter("employerId", employerId)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }

    @Override
    public List<Vacancy> findPageByActiveAndTitleWithEmployer(String titleQuery, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT opportunity
                        FROM Vacancy opportunity
                          JOIN FETCH opportunity.employer
                        WHERE opportunity.isActive
                          AND opportunity.title ILIKE :titleQuery
                        ORDER BY opportunity.createdAt DESC
                        """, Vacancy.class)
                .setParameter("titleQuery", titleQuery)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }
}
