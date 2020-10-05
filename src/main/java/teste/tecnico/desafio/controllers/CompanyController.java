package teste.tecnico.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.web.bind.annotation.*;
import teste.tecnico.desafio.beans.CompanyBean;
import teste.tecnico.desafio.repositories.CompanyRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping(value = "{companyId}")
    public Optional<CompanyBean> findById (@PathVariable("companyId") Integer companyId){
        return companyRepository.findById(companyId);
    }

    @GetMapping(value = "acceleration/{accelerationId}")
    public List<CompanyBean> findbyAccelerationId (@PathVariable("accelerationId") Integer accelerationId){
        return companyRepository.findbyAccelerationId(accelerationId);
    }

    @GetMapping(value = "user/{userId}")
    public List<CompanyBean> findByUserId (@PathVariable("userId") Integer userId){
        return companyRepository.findByUserId(userId);
    }

    @PostMapping()
    public CompanyBean save (@RequestBody CompanyBean company){
        return companyRepository.save(company);
    }
}
