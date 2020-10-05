package teste.tecnico.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import teste.tecnico.desafio.beans.CandidateBean;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository <CandidateBean, Integer> {

    @Query("select c from CandidateBean c where c.candidateKeyBean.companyId = ?1")
    List<CandidateBean> findByCompanyId(Integer companyId);

    @Query("select c from CandidateBean c where c.candidateKeyBean.accelerationId = ?1")
    List<CandidateBean> findByAccelerationId(Integer accelerationId);
}
