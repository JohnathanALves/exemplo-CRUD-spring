package teste.tecnico.desafio.beans;

import lombok.Data;

import javax.persistence.*;

@Entity()
@Table(name="candidate")
@Data
public class CandidateBean extends AbstractBean{

    @EmbeddedId
    private CandidateKeyBean candidateKeyBean;

    @Column
    private Integer status;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private UserBean user;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private AccelerationBean acceleration;

    @ManyToOne()
    @JoinColumn(insertable = false, updatable = false)
    private CompanyBean company;
}
