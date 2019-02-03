package am.foolSec.example.thymeleafFoolSec.repository;


import am.foolSec.example.thymeleafFoolSec.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findOneByLogin(String login);
}
