package by.tms.job_finder.repository;

import by.tms.job_finder.entity.VacancyAddData;

import java.util.List;

public interface VacancyAddDataRepository extends BaseRepository<VacancyAddData, Long> {

    List<VacancyAddData> findPageByVacancyWithCandidate(long opportunityId, int pageSize, int pageNumber);

    List<VacancyAddData> findPageByEmployerWithVacancyAndCandidate(long employerId, int pageSize, int pageNumber);
}
