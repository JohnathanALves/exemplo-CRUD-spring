package teste.tecnico.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teste.tecnico.desafio.beans.CandidateBean;
import teste.tecnico.desafio.repositories.CandidateRepository;

import java.util.List;

@RestController
@RequestMapping("candidate/")
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping(value = "company/{companyId}")
    public List<CandidateBean> findByCompanyId(@PathVariable("companyId") Integer companyId){
        return candidateRepository.findByCompanyId(companyId);
    }

    @GetMapping(value = "acceleration/{accelerationId}")
    public List<CandidateBean> findByAccelerationId(@PathVariable("accelerationId") Integer accelerationId){
        return candidateRepository.findByAccelerationId(accelerationId);
    }

    @PostMapping
    public CandidateBean save(@RequestBody CandidateBean candidate){
        return candidateRepository.save(candidate);
    }
}
