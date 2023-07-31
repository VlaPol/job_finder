package by.tms.job_finder.repository;

import by.tms.job_finder.dto.VacancyAddDataDTO;
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
                        SELECT a
                        FROM VacancyAddData a
                          JOIN FETCH a.candidate
                          JOIN FETCH a.candidate.cv
                        WHERE a.vacancy.id = :vacancyId
                        ORDER BY a.createdAt DESC
                        """, VacancyAddData.class)
                .setParameter("vacancyId", pro.getObjectId())
                .setMaxResults(pro.getPageSize())
                .setFirstResult(pro.getPageSize() * pro.getPageNumber())
                .getResultList();
    }

    @Override
    public void create(VacancyAddDataDTO entity) {
        entityManager.persist(entity);
    }
}
