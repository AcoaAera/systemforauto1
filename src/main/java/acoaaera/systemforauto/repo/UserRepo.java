package acoaaera.systemforauto.repo;

import acoaaera.systemforauto.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    List<User> findAllByRole(Long role);

    User findByLoginAndPass(String login, String pass);
}
