package by.tms.job_finder.service;

import by.tms.job_finder.dto.PagingRequestObject;
import by.tms.job_finder.dto.VacancyAddDataDTO;
import by.tms.job_finder.entity.Candidate;
import by.tms.job_finder.entity.Vacancy;
import by.tms.job_finder.entity.VacancyAddData;
import by.tms.job_finder.exception.BusinessException;
import by.tms.job_finder.repository.CandidateRepository;
import by.tms.job_finder.repository.VacancyAddDataRepository;
import by.tms.job_finder.repository.VacancyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VacancyAddDataServiceImpl implements VacancyAddDataService {

    private final VacancyAddDataRepository vacancyAddDataRepository;
    private final CandidateRepository candidateRepository;
    private final VacancyRepository vacancyRepository;

    @Override
    public VacancyAddData getReferenceById(Long id) {
        return vacancyAddDataRepository.getReferenceById(id);
    }

    @Override
    public VacancyAddData findById(Long id) throws BusinessException {
        return vacancyAddDataRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Информация отсутствует"));
    }

    @Override
    public void create(VacancyAddDataDTO inputData) {
        Candidate candidate = candidateRepository.findById(inputData.getCandidateId())
                .orElseThrow(() -> new BusinessException("Нет кандидата"));
        Vacancy vacancy = vacancyRepository.findById(inputData.getVacancyId())
                .orElseThrow(() -> new BusinessException("Нет вакансии"));
        VacancyAddData entity = new VacancyAddData();
        entity.setCreatedAt(Instant.now());
        entity.setCandidate(candidate);
        entity.setVacancy(vacancy);
        entity.setCoveringLetter(inputData.getCoveringLetter());
        vacancyAddDataRepository.create(entity);
    }

    @Override
    public void remove(VacancyAddData entity) {
        vacancyAddDataRepository.remove(entity.getId());
    }

    @Override
    public List<VacancyAddData> findPageByVacancyWithCandidate(PagingRequestObject pro) {
        List<VacancyAddData> pageByVacancy = vacancyAddDataRepository.findPageByVacancyWithCandidate(pro);
        return pageByVacancy.isEmpty()
                ? Collections.emptyList()
                : pageByVacancy;
    }
}
