package github.bahncard.demo.ems.repository;

import github.bahncard.demo.ems.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
