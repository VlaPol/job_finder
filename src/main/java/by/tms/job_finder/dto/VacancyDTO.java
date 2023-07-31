package by.tms.job_finder.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class VacancyDTO {

    private String employerName;
    private String title;
    private String vacancyDescription;
    private Boolean isActive;
    private Instant createdAt;
}
