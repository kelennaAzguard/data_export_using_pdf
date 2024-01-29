package pdf.export.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pdf.export.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
