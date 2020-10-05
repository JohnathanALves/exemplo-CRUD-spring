package teste.tecnico.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import teste.tecnico.desafio.beans.SubmissionBean;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<SubmissionBean, Integer> {

    @Query("select s from SubmissionBean s " +
            "where s.submissionKeyBean.challengeId = ?1 " +
            "and ROWNUM = 1 " +
            "order by s.score DESC ")
    SubmissionBean findHigherScoreByChallengeId(Integer challengeId);

    @Query("select s from SubmissionBean s " +
            "inner join CandidateBean c on (s.submissionKeyBean.userId = c.candidateKeyBean.userId) " +
            "where s.submissionKeyBean.challengeId = ?1 and c.candidateKeyBean.accelerationId = ?2")
    List<SubmissionBean> findByChallengeIdAndAccelerationId(Integer challengeId, Integer accelerationId);
}
