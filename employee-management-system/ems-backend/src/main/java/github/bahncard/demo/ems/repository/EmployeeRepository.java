package github.bahncard.demo.ems.repository;

import github.bahncard.demo.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
