package by.tms.job_finder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class VacancyAddDataDTO {

    private Long candidateId;
    private Long vacancyId;
    private Instant createdAt;
    private String coveringLetter;

}
