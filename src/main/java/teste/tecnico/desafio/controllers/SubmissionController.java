package teste.tecnico.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teste.tecnico.desafio.beans.SubmissionBean;
import teste.tecnico.desafio.repositories.SubmissionRepository;

import java.util.List;

@RestController
@RequestMapping("submission/")
public class SubmissionController {
    @Autowired
    private SubmissionRepository submissionRepository;

    @GetMapping(value = "challenge/{challengeId}")
    public SubmissionBean findHigherScoreByChallengeId(@PathVariable("challengeId") Integer challengeId){
        return submissionRepository.findHigherScoreByChallengeId(challengeId);
    }

    @GetMapping(value = "challenge/{challengeId}/acceleration/{accelerationId}")
    public List<SubmissionBean> findByChallengeIdAndAccelerationId(@PathVariable("challengeId") Integer challengeId, @PathVariable("accelerationId") Integer accelerationId){
        return submissionRepository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    @PostMapping()
    public SubmissionBean save(@RequestBody SubmissionBean submissionBean){
        return submissionRepository.save(submissionBean);
    }
}
