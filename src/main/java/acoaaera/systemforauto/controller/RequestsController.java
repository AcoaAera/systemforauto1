package acoaaera.systemforauto.controller;

import acoaaera.systemforauto.domain.Requests;
import acoaaera.systemforauto.repo.RequestsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("requests")
public class RequestsController {

    private final RequestsRepo requestsRepo;

    public RequestsController(RequestsRepo requestsRepo) {
        this.requestsRepo = requestsRepo;
    }

    @GetMapping
    public List<Requests> list() {
        return requestsRepo.findAll();
    }

    @GetMapping(value = "{id}")
    public Requests getOne(@PathVariable("id") Requests requests) {
        return requests;
    }

    @PostMapping
    public Requests create(@RequestBody Requests requests){
        return requestsRepo.save(requests);
    }

    @PutMapping("{id}")
    public Requests updateStop(
            @PathVariable("id") Requests requestsFromDb,
            @RequestBody Requests requests){
        BeanUtils.copyProperties(requests, requestsFromDb, "id");

        return requestsRepo.save(requestsFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Requests requests){
         requestsRepo.delete(requests);
    }
}
