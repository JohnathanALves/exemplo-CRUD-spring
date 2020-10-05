package teste.tecnico.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import teste.tecnico.desafio.beans.ChallengeBean;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<ChallengeBean, Integer> {

    @Query("select challenge from ChallengeBean challenge " +
            "inner join AccelerationBean acc on (challenge.id = acc.challengeId) " +
            "inner join SubmissionBean sub on (challenge.id = sub.submissionKeyBean.challengeId)" +
            "where acc.id = ?1 and sub.submissionKeyBean.userId = ?2")
    List<ChallengeBean> findByAccelerationIdAndUserId (Integer accelerationId, Integer userId);
}
