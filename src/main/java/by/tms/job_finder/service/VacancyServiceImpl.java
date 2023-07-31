package by.tms.job_finder.service;

import by.tms.job_finder.dto.PagingRequestObject;
import by.tms.job_finder.dto.VacancyDTO;
import by.tms.job_finder.entity.Employer;
import by.tms.job_finder.entity.Vacancy;
import by.tms.job_finder.exception.BusinessException;
import by.tms.job_finder.repository.EmployerRepository;
import by.tms.job_finder.repository.VacancyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final EmployerRepository employerRepository;

    @Override
    public Vacancy getReferenceById(Long id) {
        return vacancyRepository.getReferenceById(id);
    }

    @Override
    public VacancyDTO findById(Long id) throws BusinessException {
            return convertVacancyToDto(vacancyRepository.findById(id)
                    .orElseThrow(()->new BusinessException("Вакансия по указанному id не обнаружено")));
    }

    @Override
    public void create(Vacancy entity, Long id) {
        entity.setCreatedAt(Instant.now());
        Optional<Employer> employer = employerRepository.findById(id);
        employer.ifPresent(entity::setEmployer);
        vacancyRepository.create(entity);
    }

    @Override
    public void remove(Vacancy entity) {
        vacancyRepository.remove(entity.getId());
    }

    @Override
    public List<VacancyDTO> findPageByEmployer(PagingRequestObject pro) {
        List<Vacancy> pageByEmployer = vacancyRepository.findPageByEmployer(pro);
        List<VacancyDTO> returnedResult = new ArrayList<>();
        if (pageByEmployer.isEmpty()) {
            return Collections.emptyList();
        } else {
            for (Vacancy itm : pageByEmployer) {
                returnedResult.add(convertVacancyToDto(itm));
            }
        }
        return returnedResult;
    }

    private static VacancyDTO convertVacancyToDto(Vacancy entity) {
        VacancyDTO dto = new VacancyDTO();
        dto.setEmployerName(entity.getEmployer().getEmployerName());
        dto.setTitle(entity.getTitle());
        dto.setVacancyDescription(entity.getVacancyDescription());
        dto.setIsActive(entity.getIsActive());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

}
