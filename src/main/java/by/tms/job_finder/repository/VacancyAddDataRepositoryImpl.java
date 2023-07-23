package by.tms.job_finder.repository;

import by.tms.job_finder.entity.VacancyAddData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VacancyAddDataRepositoryImpl
        extends BaseRepositoryImpl<VacancyAddData, Long>
        implements VacancyAddDataRepository {

    public VacancyAddDataRepositoryImpl() {
        super(VacancyAddData.class);
    }

    @Override
    public List<VacancyAddData> findPageByVacancyWithCandidate(long opportunityId, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT apply
                        FROM VacancyAddData apply
                          JOIN FETCH apply.candidate
                          JOIN FETCH apply.candidate.cv
                        WHERE apply.vacancy.id = :opportunityId
                        ORDER BY apply.createdAt DESC
                        """, VacancyAddData.class)
                .setParameter("opportunityId", opportunityId)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }

    @Override
    public List<VacancyAddData> findPageByEmployerWithVacancyAndCandidate(long employerId, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT apply
                        FROM VacancyAddData apply
                          JOIN FETCH apply.vacancy
                          JOIN FETCH apply.candidate
                          JOIN FETCH apply.candidate.cv
                        WHERE apply.vacancy.employer.id = :employerId
                        ORDER BY apply.createdAt DESC
                        """, VacancyAddData.class)
                .setParameter("employerId", employerId)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }
}
