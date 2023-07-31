package by.tms.job_finder.service;

import by.tms.job_finder.dto.CandidateDTO;
import by.tms.job_finder.entity.Candidate;
import by.tms.job_finder.exception.BusinessException;
import by.tms.job_finder.repository.CandidateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    @Override
    public Candidate getReferenceById(Long id) {
        return candidateRepository.getReferenceById(id);
    }

    @Override
    public Candidate findById(Long id) throws BusinessException {
        return candidateRepository.findById(id)
                .orElseThrow(()->new BusinessException("Кандидата по указанному id не обнаружено"));
    }

    @Override
    public void create(CandidateDTO entity) {
        candidateRepository.saveCandidateWithCV(entity);
    }

    @Override
    public void remove(Candidate entity) {
        candidateRepository.remove(entity.getId());
    }
}
