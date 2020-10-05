package teste.tecnico.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import teste.tecnico.desafio.beans.CompanyBean;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyBean, Integer> {

    @Query("select c from CompanyBean c " +
            "inner join CandidateBean can on (c.id = can.candidateKeyBean.companyId) " +
            "where can.candidateKeyBean.accelerationId = ?1")
    List<CompanyBean> findbyAccelerationId(Integer accelerationId);

    @Query("select c from CompanyBean c " +
            "inner join CandidateBean can on (c.id = can.candidateKeyBean.companyId) " +
            "where can.candidateKeyBean.userId = ?1")
    List<CompanyBean> findByUserId(Integer userId);
}
