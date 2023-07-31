package by.tms.job_finder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "cv")
public class Cv {

    @Id
    @Column(name = "candidate_id", nullable = false)
    @JsonIgnore
    private Long candidateId;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
    private Candidate candidate;

    @Column(name = "content", nullable = false)
    private String content;
}