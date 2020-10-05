package teste.tecnico.desafio.beans;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "submission")
@Data
public class SubmissionBean extends AbstractBean {

    @EmbeddedId
    private SubmissionKeyBean submissionKeyBean;

    @Column
    private Float score;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private UserBean user;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private ChallengeBean challenge;

}
