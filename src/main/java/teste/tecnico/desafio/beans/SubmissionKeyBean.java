package teste.tecnico.desafio.beans;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class SubmissionKeyBean implements Serializable {
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "challenge_id")
    private Integer challengeId;

    public SubmissionKeyBean(Integer userId, Integer challengeId) {
        this.userId = userId;
        this.challengeId = challengeId;
    }

    public SubmissionKeyBean() {

    }
}
