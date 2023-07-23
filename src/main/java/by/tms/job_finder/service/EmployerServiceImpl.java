package by.tms.job_finder.service;

import by.tms.job_finder.entity.Candidate;
import by.tms.job_finder.entity.Employer;
import by.tms.job_finder.exception.BusinessException;
import by.tms.job_finder.repository.EmployerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;

    @Override
    public Employer getReferenceById(Long id) {
        return employerRepository.getReferenceById(id);
    }

    @Override
    public Employer findById(Long id) throws BusinessException {
        Optional<Employer> employer = employerRepository.findById(id);
        if (employer.isPresent()) {
            return employer.get();
        } else {
            throw new BusinessException("Работодатель по указанному id не обнаружено");
        }
    }

    @Override
    public void create(Employer entity) {
        employerRepository.create(entity);
    }

    @Override
    public void remove(Employer entity) {
        employerRepository.remove(entity);
    }
}
