package by.tms.job_finder.controller;

import by.tms.job_finder.dto.PagingRequestObject;
import by.tms.job_finder.dto.VacancyAddDataDTO;
import by.tms.job_finder.entity.VacancyAddData;
import by.tms.job_finder.service.VacancyAddDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/info")
public class AddInfoController {

    VacancyAddDataService addDataService;

    @GetMapping("/reference/{id}")
    VacancyAddData findReferenceById(@PathVariable Long id) {
        return addDataService.getReferenceById(id);
    }

    @GetMapping("/{id}")
    VacancyAddData findAddInfoById(@PathVariable Long id) {
        return addDataService.findById(id);
    }

    @PostMapping("/add")
    void createNewAddInfo(@RequestBody VacancyAddDataDTO info) {
        addDataService.create(info);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteAddInfo(@RequestBody VacancyAddData info) {

        addDataService.remove(info);
    }

    @GetMapping("/vacancies")
    List<VacancyAddData> getVacancyByCandidate(@RequestBody PagingRequestObject pro) {
        return addDataService.findPageByVacancyWithCandidate(pro);
    }

}
