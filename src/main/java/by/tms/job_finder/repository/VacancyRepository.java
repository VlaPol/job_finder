package by.tms.job_finder.repository;

import by.tms.job_finder.dto.PagingRequestObject;
import by.tms.job_finder.entity.Vacancy;

import java.util.List;

public interface VacancyRepository extends BaseRepository<Vacancy, Long> {

    List<Vacancy> findPageByEmployer(PagingRequestObject pro);
}
