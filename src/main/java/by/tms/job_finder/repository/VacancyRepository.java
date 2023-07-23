package by.tms.job_finder.repository;

import by.tms.job_finder.entity.Vacancy;

import java.util.List;

public interface VacancyRepository extends BaseRepository<Vacancy, Long> {

    List<Vacancy> findPageByEmployer(long employerId, int pageSize, int pageNumber);

    List<Vacancy> findPageByActiveAndTitleWithEmployer(String titleQuery, int limit, int offset);
}
