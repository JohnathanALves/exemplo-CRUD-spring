package teste.tecnico.desafio.beans;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "company")
@Data
public class CompanyBean extends AbstractBean{

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String slug;
}
