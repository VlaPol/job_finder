package by.tms.job_finder.repository;

import by.tms.job_finder.dto.PagingRequestObject;
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
    public List<Vacancy> findPageByEmployer(PagingRequestObject pro) {
        return entityManager.createQuery("""
                        SELECT v
                        FROM Vacancy v
                        WHERE v.employer.id = :employerId
                        ORDER BY v.createdAt DESC
                        """, Vacancy.class)
                .setParameter("employerId", pro.getObjectId())
                .setMaxResults(pro.getPageSize())
                .setFirstResult(pro.getPageSize() * pro.getPageNumber())
                .getResultList();
    }
}
