package by.tms.job_finder.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "candidate")
public class Candidate extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "f_name", nullable = false)
    private String firstName;

    @Column(name = "l_name", nullable = false)
    private String lastName;

    @OneToOne(mappedBy = "candidate", optional = false, cascade = CascadeType.ALL)
    private Cv cv;

    public Candidate setCv(Cv cv) {
        this.cv = cv;
        cv.setCandidate(this);
        return this;
    }
}