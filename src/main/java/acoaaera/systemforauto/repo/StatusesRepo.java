package acoaaera.systemforauto.repo;

import acoaaera.systemforauto.domain.Statuses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusesRepo extends JpaRepository<Statuses, Long> {
}
