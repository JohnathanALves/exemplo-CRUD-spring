package teste.tecnico.desafio.beans;

import lombok.Data;

import javax.persistence.*;

@Entity()
@Table(name="challenge")
@Data
public class ChallengeBean extends AbstractBean{

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String slug;
}
