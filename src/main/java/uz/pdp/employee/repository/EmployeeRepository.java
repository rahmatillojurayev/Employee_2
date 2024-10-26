package uz.pdp.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.employee.entity.Employee;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}