package uz.pdp.employee.service;

import org.springframework.stereotype.Service;
import uz.pdp.employee.entity.Employee;
import uz.pdp.employee.repository.EmployeeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(UUID id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(UUID id) {
        employeeRepository.deleteById(id);
    }
}
