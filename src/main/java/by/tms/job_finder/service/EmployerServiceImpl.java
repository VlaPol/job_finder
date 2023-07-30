package by.tms.job_finder.service;

import by.tms.job_finder.entity.Employer;
import by.tms.job_finder.exception.BusinessException;
import by.tms.job_finder.repository.EmployerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        return employerRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Работодатель по указанному id не обнаружено"));
    }

    @Override
    public void create(Employer entity) {
        employerRepository.create(entity);
    }

    @Override
    public void remove(Employer entity) {
        employerRepository.remove(entity.getId());
    }
}
