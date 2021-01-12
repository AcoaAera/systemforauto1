package acoaaera.systemforauto.controller;

import acoaaera.systemforauto.domain.Requests;
import acoaaera.systemforauto.domain.User;
import acoaaera.systemforauto.domain.Views;
import acoaaera.systemforauto.repo.UserRepo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<User> list() {
        return userRepo.findAll();
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable("id") User user) {
        return user;
    }

    @GetMapping("drivers")
    @JsonView(Views.IdName.class)
    public List<User> getOn() {
        return userRepo.findAllByRole((long) 3 );
    }

    @PostMapping("checkUser")
    public User create(@RequestBody User user){
        User info = userRepo.findByLoginAndPass(user.getLogin(),user.getPass());
        return info;
    }

    @PutMapping("{id}")
    public User update(
            @PathVariable("id") User userFromDb,
            @RequestBody User user){
        BeanUtils.copyProperties(user, userFromDb, "id");

        return userRepo.save(userFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") User user){
        userRepo.delete(user);
    }
}
