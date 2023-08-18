package by.tms.job_finder.service;

import by.tms.job_finder.dto.RegistrationCandidateDto;
import by.tms.job_finder.dto.RegistredCandidateDto;
import by.tms.job_finder.entity.Candidate;
import by.tms.job_finder.exception.BusinessException;
import by.tms.job_finder.model.token.AccessToken;

public interface CandidateService {

    Candidate getReferenceById(Long id);

    Candidate findById(Long id) throws BusinessException;

    AccessToken registrateNewCandidate(RegistrationCandidateDto entity);

    AccessToken getTokenForRegisteretCandidate(RegistredCandidateDto entity);

    void remove(Candidate entity);
}
