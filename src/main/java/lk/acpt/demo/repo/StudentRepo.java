package lk.acpt.demo.repo;

import lk.acpt.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> { // Crud eka witharak gannawanam CrudRepository Kiyala ekak thiye

}
