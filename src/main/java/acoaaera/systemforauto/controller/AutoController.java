package acoaaera.systemforauto.controller;

import acoaaera.systemforauto.domain.Auto;
import acoaaera.systemforauto.repo.AutoRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("auto")
public class AutoController {

    private final AutoRepo autoRepo;

    public AutoController(AutoRepo autoRepo) {
        this.autoRepo = autoRepo;
    }

    @GetMapping
    public List<Auto> list() {
        return autoRepo.findAll();
    }

    @GetMapping("{id}")
    public Auto getOne(@PathVariable("id") Auto auto) {
        return auto;
    }

}
