package teste.tecnico.desafio.beans;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@DynamicInsert
@Data
public class AbstractBean implements Serializable {

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    public AbstractBean() {
        this.createdAt = new Date(System.currentTimeMillis());
    }
}
