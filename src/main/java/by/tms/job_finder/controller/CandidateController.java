package by.tms.job_finder.controller;

import by.tms.job_finder.dto.RegistrationCandidateDto;
import by.tms.job_finder.entity.Candidate;
import by.tms.job_finder.service.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/candidate")
public class CandidateController {

    CandidateService candidateService;

    @GetMapping("/reference/{id}")
    Candidate findReferenceById(@PathVariable Long id) {
        return candidateService.getReferenceById(id);
    }

    @GetMapping("/{id}")
    Candidate findEmployerByid(@PathVariable Long id) {
        return candidateService.findById(id);
    }

    @PostMapping("/add")
    void createNewEmployer(@RequestBody RegistrationCandidateDto candidate) {
        candidateService.registrateNewCandidate(candidate);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteCandidate(@RequestBody Candidate candidate) {

        candidateService.remove(candidate);
    }
}
