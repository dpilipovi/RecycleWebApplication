package hr.zavrsni.pilipovic.recycle.repositories;

import hr.zavrsni.pilipovic.recycle.entities.User;
import hr.zavrsni.pilipovic.recycle.entities.UserCommand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long>
{

	Optional<User> findByUsername(String username);

	void deleteByUsername(String username);

	Optional<User> findOneByUsername(String username);

	User save(User user);

}