package by.tms.job_finder.controller;

import by.tms.job_finder.entity.Employer;
import by.tms.job_finder.service.EmployerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/employer")
public class EmployerController {

    EmployerService employerService;

    @GetMapping("/reference/{id}")
    Employer findReferenceById(@PathVariable Long id) {
        return employerService.getReferenceById(id);
    }

    @GetMapping("/{id}")
    Employer findEmployerByid(@PathVariable Long id) {
        return employerService.findById(id);
    }

    @PostMapping("/add")
    void createNewEmployer(@RequestBody Employer emp) {
        employerService.create(emp);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteEmployer(@RequestBody Employer emp) {
        employerService.remove(emp);
    }

}
