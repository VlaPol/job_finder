package by.tms.job_finder.service;

import by.tms.job_finder.dto.CandidateDTO;
import by.tms.job_finder.entity.Candidate;
import by.tms.job_finder.exception.BusinessException;

public interface CandidateService {

    Candidate getReferenceById(Long id);

    Candidate findById(Long id) throws BusinessException;

    void create(CandidateDTO entity);

    void remove(Candidate entity);
}
