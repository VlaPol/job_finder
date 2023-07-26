package by.tms.job_finder.service;

import by.tms.job_finder.entity.Candidate;
import by.tms.job_finder.exception.BusinessException;
import by.tms.job_finder.repository.CandidateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isPresent()) {
            return candidate.get();
        } else {
            throw new BusinessException("Кандидата по указанному id не обнаружено");
        }

    }

    @Override
    public void create(Candidate entity) {
        candidateRepository.create(entity);
    }

    @Override
    public void remove(Candidate entity) {
        candidateRepository.remove(entity.getId());
    }
}
