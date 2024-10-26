package uz.pdp.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.employee.entity.Region;
import uz.pdp.employee.service.RegionService;

import java.util.List;

@RestController
@RequestMapping("/api/region")
@Tag(name = "Region API", description = "Region ma'lumotlarini boshqarish uchun API")
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @Operation(summary = "Barcha region'larni olish", description = "Barcha region yozuvlarini qaytaradi")
    @GetMapping
    public ResponseEntity<List<Region>> getAll() {
        return ResponseEntity.ok(regionService.getAll());
    }

    @Operation(summary = "ID bo'yicha region'ni olish", description = "Berilgan ID bo'yicha region yozuvini qaytaradi")
    @GetMapping("/{id}")
    public ResponseEntity<Region> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(regionService.getById(id));
    }

    @Operation(summary = "Yangi region yaratish", description = "Yangi region yozuvini yaratadi")
    @PostMapping
    public ResponseEntity<Region> create(@RequestBody Region region) {
        return ResponseEntity.ok(regionService.save(region));
    }

    @Operation(summary = "Region'ni o'chirish", description = "Berilgan ID bo'yicha region yozuvini o'chiradi")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        regionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
