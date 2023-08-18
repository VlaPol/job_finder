package by.tms.job_finder.dto;

import lombok.Value;

@Value
public class RegistrationCandidateDto {
    String email;
    String firstName;
    String lastName;
    String password;
    CvDto candidateCv;
}
