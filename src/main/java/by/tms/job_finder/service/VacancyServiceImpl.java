package by.tms.job_finder.service;

import by.tms.job_finder.entity.Vacancy;
import by.tms.job_finder.exception.BusinessException;
import by.tms.job_finder.repository.VacancyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;

    @Override
    public Vacancy getReferenceById(Long id) {
        return vacancyRepository.getReferenceById(id);
    }

    @Override
    public Vacancy findById(Long id) throws BusinessException {
        Optional<Vacancy> vacancy = vacancyRepository.findById(id);
        if (vacancy.isPresent()) {
            return vacancy.get();
        } else {
            throw new BusinessException("Вакансия по указанному id не обнаружено");
        }
    }

    @Override
    public void create(Vacancy entity) {
        vacancyRepository.create(entity);
    }

    @Override
    public void remove(Vacancy entity) {
        vacancyRepository.remove(entity);
    }

    @Override
    public List<Vacancy> findPageByEmployer(long empId, int pageSize, int pageNumber) {
        List<Vacancy> pageByEmployer = vacancyRepository.findPageByEmployer(empId, pageSize, pageNumber);
        return pageByEmployer.isEmpty()
                ? Collections.emptyList()
                : pageByEmployer;
    }

}
