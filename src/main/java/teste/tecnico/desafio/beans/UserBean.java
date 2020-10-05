package teste.tecnico.desafio.beans;

import lombok.Data;
import javax.persistence.*;

@Entity()
@Table(name="user")
@Data
public class UserBean extends AbstractBean{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column
    private String email;

    @Column
    private String nickname;

    @Column
    private String password;

}
