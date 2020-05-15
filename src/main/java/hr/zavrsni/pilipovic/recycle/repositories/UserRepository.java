package hr.zavrsni.pilipovic.recycle.repositories;

import hr.zavrsni.pilipovic.recycle.entities.User;
import hr.zavrsni.pilipovic.recycle.entities.UserCommand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long>
{

	User findByUsername(String username);

	void deleteByUsername(String username);

	User findOneByUsername(String username);

	User save(UserCommand user);

	User save(User user);

}