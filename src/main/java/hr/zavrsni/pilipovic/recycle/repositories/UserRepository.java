package hr.zavrsni.pilipovic.recycle.repositories;

import hr.zavrsni.pilipovic.recycle.entities.User;
import hr.zavrsni.pilipovic.recycle.entities.UserCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{

	Optional<User> findByUsername(String username);

	@Transactional
	void deleteByUsername(String username);

	Optional<User> findOneByUsername(String username);

	User save(User user);

	List<User> findAll();

}