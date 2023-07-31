package by.tms.job_finder.service;

import by.tms.job_finder.dto.PagingRequestObject;
import by.tms.job_finder.dto.VacancyDTO;
import by.tms.job_finder.entity.Vacancy;
import by.tms.job_finder.exception.BusinessException;

import java.util.List;

public interface VacancyService {

    Vacancy getReferenceById(Long id);

    VacancyDTO findById(Long id) throws BusinessException;

    void create(Vacancy entity, Long id);

    void remove(Vacancy entity);

    List<VacancyDTO> findPageByEmployer(PagingRequestObject pro);

}
