package acoaaera.systemforauto.repo;

import acoaaera.systemforauto.domain.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestsRepo extends JpaRepository<Requests, Long> {
}
