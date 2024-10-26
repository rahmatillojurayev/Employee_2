package uz.pdp.employee.service;

import org.springframework.stereotype.Service;
import uz.pdp.employee.entity.CalculationTable;
import uz.pdp.employee.repository.CalculationTableRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CalculationTableService {
    private final CalculationTableRepository calculationTableRepository;

    public CalculationTableService(CalculationTableRepository calculationTableRepository) {
        this.calculationTableRepository = calculationTableRepository;
    }

    public List<CalculationTable> getAll() {
        return calculationTableRepository.findAll();
    }

    public CalculationTable getById(UUID id) {
        return calculationTableRepository.findById(id).orElse(null);
    }

    public CalculationTable save(CalculationTable calculationTable) {
        return calculationTableRepository.save(calculationTable);
    }

    public void delete(UUID id) {
        calculationTableRepository.deleteById(id);
    }

    public List<Object[]> getPrinflWithTotalRateNative(String month, int rate) {
        return calculationTableRepository.findPrinflWithTotalRateNative(month, rate);
    }

    public List<Object[]> getPrinflWithOrgCountAndTotalSalary(String month) {
        return calculationTableRepository.findPrinflWithOrgCountAndTotalSalary(month);
    }

    public List<Object[]> getAverageSalaryAndEmployeeDataByOrganization(String month, int organizationId) {
        return calculationTableRepository.findAverageSalaryAndEmployeeDataByOrganization(month, organizationId);
    }

    public List<Object[]> getSalaryAndVacationByMonth(String month) {
        return calculationTableRepository.findSalaryAndVacationByMonth(month);
    }
}
