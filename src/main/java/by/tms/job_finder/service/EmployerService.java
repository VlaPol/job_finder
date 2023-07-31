package by.tms.job_finder.service;

import by.tms.job_finder.entity.Employer;
import by.tms.job_finder.exception.BusinessException;

public interface EmployerService {

    Employer getReferenceById(Long id);

    Employer findById(Long id) throws BusinessException;

    void create(Employer entity);

    void remove(Employer entity);
}
