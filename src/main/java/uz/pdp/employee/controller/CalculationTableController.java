package uz.pdp.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.employee.entity.CalculationTable;
import uz.pdp.employee.service.CalculationTableService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/calculation")
@Tag(name = "Calculation API", description = "Ma'lumotlarni boshqarish uchun Calculation API")
public class CalculationTableController {

    private final CalculationTableService calculationTableService;

    public CalculationTableController(CalculationTableService calculationTableService) {
        this.calculationTableService = calculationTableService;
    }

    @Operation(summary = "Barcha CalculationTable ma'lumotlarini olish", description = "Barcha CalculationTable yozuvlarini qaytaradi")
    @GetMapping
    public ResponseEntity<List<CalculationTable>> getAll() {
        return ResponseEntity.ok(calculationTableService.getAll());
    }

    @Operation(summary = "ID bo'yicha CalculationTable ma'lumotini olish", description = "Berilgan ID bo'yicha CalculationTable yozuvini qaytaradi")
    @GetMapping("/{id}")
    public ResponseEntity<CalculationTable> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(calculationTableService.getById(id));
    }

    @Operation(summary = "Yangi CalculationTable yozuvini yaratish", description = "Yangi CalculationTable yozuvini saqlaydi")
    @PostMapping
    public ResponseEntity<CalculationTable> create(@RequestBody CalculationTable calculationTable) {
        return ResponseEntity.ok(calculationTableService.save(calculationTable));
    }

    @Operation(summary = "CalculationTable yozuvini o'chirish", description = "Berilgan ID bo'yicha CalculationTable yozuvini o'chiradi")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        calculationTableService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "PINFL va ish stavkasi bo'yicha", description = "So'ralgan oyda ko'proq ish stavkasi bilan ishlagan PINFL'larni qaytaradi")
    @GetMapping("/total-rate")
    public ResponseEntity<List<Object[]>> getPrinflWithTotalRate(@RequestParam String month, @RequestParam int rate) {
        List<Object[]> result = calculationTableService.getPrinflWithTotalRateNative(month, rate);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Turli regionlarda ishlagan PINFL va umumiy oylik ish haqisi", description = "So'ralgan oyda bir xil PINFL'larning regionlarga nisbatan ish haqisi haqida ma'lumot qaytaradi")
    @GetMapping("/org-salary")
    public ResponseEntity<List<Object[]>> getPrinflWithOrgCountAndTotalSalary(@RequestParam String month) {
        List<Object[]> result = calculationTableService.getPrinflWithOrgCountAndTotalSalary(month);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "O'rtacha ish haqi va employee ma'lumotlari", description = "Berilgan oyda tashkilot bo'yicha employee'larning o'rtacha ish haqisi haqida ma'lumot qaytaradi")
    @GetMapping("/avg-salary/{organizationId}")
    public ResponseEntity<List<Object[]>> getAverageSalaryAndEmployeeDataByOrganization(
            @RequestParam String month, @PathVariable int organizationId) {
        List<Object[]> result = calculationTableService.getAverageSalaryAndEmployeeDataByOrganization(month, organizationId);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Ish haqi va ta'til puli", description = "So'ralgan oyda ish haqi va ta'til puli olgan employee'lar haqida ma'lumot qaytaradi")
    @GetMapping("/salary-vacation")
    public ResponseEntity<List<Object[]>> getSalaryAndVacationByMonth(@RequestParam String month) {
        List<Object[]> result = calculationTableService.getSalaryAndVacationByMonth(month);
        return ResponseEntity.ok(result);
    }
}
