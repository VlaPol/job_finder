package by.tms.job_finder.dto;

import by.tms.job_finder.entity.Candidate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CandidateDTO {

    private Candidate candidate;
    private String cvContent;
}
