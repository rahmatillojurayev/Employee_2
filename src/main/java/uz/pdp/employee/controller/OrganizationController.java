package uz.pdp.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.employee.entity.Organization;
import uz.pdp.employee.service.OrganizationService;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
@Tag(name = "Organization API", description = "Organization ma'lumotlarini boshqarish uchun API")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Operation(summary = "Barcha organization'larni olish", description = "Barcha organization yozuvlarini qaytaradi")
    @GetMapping
    public ResponseEntity<List<Organization>> getAll() {
        return ResponseEntity.ok(organizationService.getAll());
    }

    @Operation(summary = "ID bo'yicha organization'ni olish", description = "Berilgan ID bo'yicha organization yozuvini qaytaradi")
    @GetMapping("/{id}")
    public ResponseEntity<Organization> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(organizationService.getById(id));
    }

    @Operation(summary = "Yangi organization yaratish", description = "Yangi organization yozuvini yaratadi")
    @PostMapping
    public ResponseEntity<Organization> create(@RequestBody Organization organization) {
        return ResponseEntity.ok(organizationService.save(organization));
    }

    @Operation(summary = "Organization'ni o'chirish", description = "Berilgan ID bo'yicha organization yozuvini o'chiradi")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        organizationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
