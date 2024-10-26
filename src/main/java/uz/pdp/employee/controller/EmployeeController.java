package uz.pdp.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.employee.entity.Employee;
import uz.pdp.employee.service.EmployeeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
@Tag(name = "Employee API", description = "Employee ma'lumotlarini boshqarish uchun API")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Barcha employee'larni olish", description = "Barcha employee yozuvlarini qaytaradi")
    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @Operation(summary = "ID bo'yicha employee'ni olish", description = "Berilgan ID bo'yicha employee yozuvini qaytaradi")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @Operation(summary = "Yangi employee yaratish", description = "Yangi employee yozuvini yaratadi")
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @Operation(summary = "Employee'ni o'chirish", description = "Berilgan ID bo'yicha employee yozuvini o'chiradi")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
