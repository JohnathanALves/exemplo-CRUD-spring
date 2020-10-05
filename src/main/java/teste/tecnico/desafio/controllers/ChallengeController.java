package teste.tecnico.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teste.tecnico.desafio.beans.AccelerationBean;
import teste.tecnico.desafio.beans.ChallengeBean;
import teste.tecnico.desafio.repositories.ChallengeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("challenge")
public class ChallengeController {

    @Autowired
    private ChallengeRepository challengeRepository;

    @GetMapping(value = "acceleration/{accelerationId}/user/{userId}")
    public List<ChallengeBean> findByAccelerationIdAndUserId(Integer accelerationId, Integer userId){
        return challengeRepository.findByAccelerationIdAndUserId(accelerationId, userId);
    }

    @PostMapping()
    public ChallengeBean save (@RequestBody ChallengeBean challenge){
        return challengeRepository.save(challenge);
    }
}
