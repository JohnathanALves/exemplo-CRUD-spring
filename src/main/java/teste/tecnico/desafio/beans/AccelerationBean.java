package teste.tecnico.desafio.beans;

import lombok.Data;

import javax.persistence.*;

@Entity()
@Table(name="acceleration")
@Data
public class AccelerationBean extends AbstractBean {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String slug;

    @Column(name = "challenge_id")
    private Integer challengeId;

    @ManyToOne
    @JoinColumn(name = "challenge_id",referencedColumnName = "id", updatable = false, insertable = false)
    private ChallengeBean challenge;

}
