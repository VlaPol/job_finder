package by.tms.job_finder.service;

import by.tms.job_finder.entity.VacancyAddData;
import by.tms.job_finder.exception.BusinessException;

import java.util.List;

public interface VacancyAddDataService {
    VacancyAddData getReferenceById(Long id);

    VacancyAddData findById(Long id) throws BusinessException;

    void create(VacancyAddData entity);

    void remove(VacancyAddData entity);

    List<VacancyAddData> findPageByVacancyWithCandidate(long vacancyId, int pageSize, int pageNumber);
}
