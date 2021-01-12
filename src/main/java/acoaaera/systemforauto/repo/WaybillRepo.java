package acoaaera.systemforauto.repo;

import acoaaera.systemforauto.domain.User;
import acoaaera.systemforauto.domain.Waybill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaybillRepo extends JpaRepository<Waybill, Long> {
    List<Waybill> findAllByDriver(User driver);
}
