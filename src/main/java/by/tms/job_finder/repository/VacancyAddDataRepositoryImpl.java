package by.tms.job_finder.repository;

import by.tms.job_finder.dto.PagingRequestObject;
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
    public List<VacancyAddData> findPageByVacancyWithCandidate(PagingRequestObject pro) {
        return entityManager.createQuery("""
                        SELECT apply
                        FROM VacancyAddData apply
                          JOIN FETCH apply.candidate
                          JOIN FETCH apply.candidate.cv
                        WHERE apply.vacancy.id = :opportunityId
                        ORDER BY apply.createdAt DESC
                        """, VacancyAddData.class)
                .setParameter("opportunityId", pro.getObjectId())
                .setMaxResults(pro.getPageSize())
                .setFirstResult(pro.getPageSize() * pro.getPageNumber())
                .getResultList();
    }
}
