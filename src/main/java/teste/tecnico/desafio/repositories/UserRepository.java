package teste.tecnico.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import teste.tecnico.desafio.beans.UserBean;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Integer> {

    @Query("select u from UserBean u " +
            "inner join CandidateBean c on (u.id = c.candidateKeyBean.userId) " +
            "inner join AccelerationBean acc on (c.candidateKeyBean.accelerationId = acc.id) " +
            "where acc.name = ?1")
    List<UserBean> findByAccelerationName(String accelerationName);

    @Query("select u from UserBean u " +
            "inner join CandidateBean c on (u.id = c.candidateKeyBean.userId) " +
            "inner join CompanyBean comp on (c.candidateKeyBean.companyId = comp.id) " +
            "where comp.id = ?1"
    )
    List<UserBean> findByCompanyId(Integer companyId);
}