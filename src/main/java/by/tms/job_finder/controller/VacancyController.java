package by.tms.job_finder.controller;

import by.tms.job_finder.dto.PagingRequestObject;
import by.tms.job_finder.dto.VacancyDTO;
import by.tms.job_finder.entity.Vacancy;
import by.tms.job_finder.service.VacancyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vacancy")
public class VacancyController {

    VacancyService vacancyService;

    @GetMapping("/reference/{id}")
    Vacancy findReferenceById(@PathVariable Long id){
        return vacancyService.getReferenceById(id);
    }
    @GetMapping("/{id}")
    VacancyDTO findVacancyById(@PathVariable Long id){
        return vacancyService.findById(id);
    }

    @PostMapping("/{empId}/add")
    void createNewVacancy(@RequestBody Vacancy vacancy, @PathVariable Long empId){
        vacancyService.create(vacancy, empId);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteVacancy(@RequestBody Vacancy vacancy){
        vacancyService.remove(vacancy);
    }

    @GetMapping("/all")
    List<VacancyDTO> getAllVacancysByEmployer(@RequestBody PagingRequestObject pro){
        return vacancyService.findPageByEmployer(pro);
    }
}
