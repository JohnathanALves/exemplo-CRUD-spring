package teste.tecnico.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teste.tecnico.desafio.beans.UserBean;
import teste.tecnico.desafio.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "acceleration/{acceleration}")
    public List<UserBean> findByAccelarationName(@PathVariable("acceleration") String acceleration){
        return userRepository.findByAccelerationName(acceleration);
    }

    @GetMapping(value = "company/{companyId}")
    public List<UserBean> findByCompanyId(@PathVariable("companyId") Integer companyId){
        return userRepository.findByCompanyId(companyId);
    }

    @GetMapping(value = "{userId}")
    public Optional<UserBean> findById(@PathVariable("userId") String userId) {
        return userRepository.findById(Integer.valueOf(userId));
    }

    @PostMapping
    public UserBean save (@RequestBody UserBean newUser) {
        System.out.println(newUser.toString());
        return userRepository.save(newUser);
    }
}
