package teste.tecnico.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teste.tecnico.desafio.beans.AccelerationBean;
import teste.tecnico.desafio.repositories.AccelerationRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationRepository accelerationRepository;

    @GetMapping(value = "{accelerationId}")
    public Optional<AccelerationBean> findAccelerationById (@PathVariable("accelerationId") Integer accelerationId){
        return accelerationRepository.findById(accelerationId);
    }

    @GetMapping(value = "company/{companyId}")
    public List<AccelerationBean> findByCompanyId (@PathVariable("companyId") Integer companyId){
        return accelerationRepository.findByCompanyId(companyId);
    }

    @GetMapping()
    public Optional<AccelerationBean> findAccelerationByName (@RequestParam("name") String name){
        return accelerationRepository.findAccelerationByName(name);
    }

    @PostMapping()
    public AccelerationBean save (@RequestBody AccelerationBean acceleration){
        return accelerationRepository.save(acceleration);
    }
}
