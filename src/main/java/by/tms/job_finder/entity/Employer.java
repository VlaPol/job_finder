package by.tms.job_finder.entity;

import by.tms.job_finder.utils.UriConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.net.URI;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "employer")
public class Employer extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "employer_name", nullable = false)
    private String employerName;

    @Column(name = "site")
    @Convert(converter = UriConverter.class)
    private URI siteUrl;
}