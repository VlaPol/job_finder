package by.tms.job_finder.service;

import by.tms.job_finder.dto.PagingRequestObject;
import by.tms.job_finder.entity.VacancyAddData;
import by.tms.job_finder.exception.BusinessException;
import by.tms.job_finder.repository.VacancyAddDataRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class VacancyAddDataServiceImpl implements  VacancyAddDataService{

    private final VacancyAddDataRepository vacancyAddDataRepository;
    @Override
    public VacancyAddData getReferenceById(Long id) {
        return vacancyAddDataRepository.getReferenceById(id);
    }

    @Override
    public VacancyAddData findById(Long id) throws BusinessException {
        Optional<VacancyAddData> vacancyAddData = vacancyAddDataRepository.findById(id);
        if (vacancyAddData.isPresent()) {
            return vacancyAddData.get();
        } else {
            throw new BusinessException("Описание вакансии по указанному id не обнаружено");
        }
    }

    @Override
    public void create(VacancyAddData entity) {
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
