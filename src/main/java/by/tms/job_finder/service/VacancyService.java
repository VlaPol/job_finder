package by.tms.job_finder.service;

import by.tms.job_finder.entity.Vacancy;
import by.tms.job_finder.exception.BusinessException;

import java.util.List;

public interface VacancyService {

    Vacancy getReferenceById(Long id);

    Vacancy findById(Long id) throws BusinessException;

    void create(Vacancy entity);

    void remove(Vacancy entity);

    List<Vacancy> findPageByEmployer(long empId, int pageSize, int pageNumber);

}
