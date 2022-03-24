package emlakburada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import emlakburada.entity.Enrollee;
import org.springframework.data.jpa.repository.Query;

public interface AuthRepository extends JpaRepository<Enrollee, Integer> {

	@Query(nativeQuery = true,value = "Select * from Enrollee")
	Enrollee findByEmail(String email);

}
