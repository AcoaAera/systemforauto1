package acoaaera.systemforauto.controller;

import acoaaera.systemforauto.domain.Statuses;
import acoaaera.systemforauto.repo.StatusesRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("statuses")
public class StatusesController {

    private final StatusesRepo statusesRepo;

    public StatusesController(StatusesRepo statusesRepo) {
        this.statusesRepo = statusesRepo;
    }

    @GetMapping
    public List<Statuses> list() {
        return statusesRepo.findAll();
    }

    @GetMapping(value = "{id}")
    public Statuses getOne(@PathVariable("id") Statuses statuses) {
        return statuses;
    }

}
