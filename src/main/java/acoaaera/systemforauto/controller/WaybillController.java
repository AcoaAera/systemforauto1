package acoaaera.systemforauto.controller;

import acoaaera.systemforauto.domain.User;
import acoaaera.systemforauto.domain.Waybill;
import acoaaera.systemforauto.repo.UserRepo;
import acoaaera.systemforauto.repo.WaybillRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("waybill")
public class WaybillController {

    private final WaybillRepo waybillRepo;
    private final UserRepo userRepo;

    public WaybillController(WaybillRepo waybillRepo, UserRepo userRepo) {
        this.waybillRepo = waybillRepo;
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<Waybill> list() {
        return waybillRepo.findAll();
    }

    @GetMapping(value = "{id}")
    public Waybill getOne(@PathVariable("id") Waybill waybill) {
        return waybill;
    }

    @GetMapping(value = "getDriver/{driver}")
    public List<Waybill> getWaybillForUser(@PathVariable("driver") Long id) {

        User user = userRepo.findById(id).get();
        List<Waybill> x = waybillRepo.findAllByDriver(user);
        return x;
    }

    @PostMapping
    public Waybill create(@RequestBody Waybill waybill){
        return waybillRepo.save(waybill);
    }

    @PutMapping("{id}")
    public Waybill update(
            @PathVariable("id") Waybill waybillFromDb,
            @RequestBody Waybill waybill){
        BeanUtils.copyProperties(waybill, waybillFromDb, "id");

        return waybillRepo.save(waybillFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Waybill waybill){
         waybillRepo.delete(waybill);
    }
}
