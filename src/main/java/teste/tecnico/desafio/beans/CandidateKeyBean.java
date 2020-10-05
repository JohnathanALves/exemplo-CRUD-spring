package teste.tecnico.desafio.beans;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class CandidateKeyBean implements Serializable {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "acceleration_id")
    private Integer accelerationId;

    @Column(name = "company_id")
    private Integer companyId;

    public CandidateKeyBean() {}

    public CandidateKeyBean(Integer userId, Integer accelerationId, Integer companyId) {
        this.userId = userId;
        this.accelerationId = accelerationId;
        this.companyId = companyId;
    }
}
