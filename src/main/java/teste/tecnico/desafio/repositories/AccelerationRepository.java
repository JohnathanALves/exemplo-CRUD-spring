package teste.tecnico.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import teste.tecnico.desafio.beans.AccelerationBean;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends JpaRepository<AccelerationBean, Integer> {

    Optional<AccelerationBean> findAccelerationByName(String name);

    @Query("select acc from AccelerationBean acc " +
            "inner join CandidateBean can on (acc.id = can.candidateKeyBean.accelerationId) " +
            "where can.candidateKeyBean.companyId = ?1")
    List<AccelerationBean> findByCompanyId(Integer companyId);
}
