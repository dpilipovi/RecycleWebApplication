package hr.zavrsni.pilipovic.recycle.repositories;

import hr.zavrsni.pilipovic.recycle.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long>
{

        Authority findByName(String name);

        List<Authority> findAll();


}
