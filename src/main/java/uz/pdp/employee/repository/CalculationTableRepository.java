package uz.pdp.employee.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.employee.entity.CalculationTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CalculationTableRepository extends JpaRepository<CalculationTable, UUID> {

    @Query(value = "SELECT e.prinfl, SUM(ct.rate) AS total_rate " +
            "FROM calculation_table ct " +
            "JOIN employee e ON ct.employee_id = e.id " +
            "WHERE TO_CHAR(ct.date, 'YYYY.MM') = :month " +
            "GROUP BY e.prinfl " +
            "HAVING SUM(ct.rate) > :rate", nativeQuery = true)
    List<Object[]> findPrinflWithTotalRateNative(@Param("month") String month, @Param("rate") int rate);


    @Query(value = "SELECT e.prinfl, " +
            "COUNT(DISTINCT o.id) AS total_organizations, " +
            "SUM(ct.amount) AS total_salary " +
            "FROM calculation_table ct " +
            "JOIN employee e ON ct.employee_id = e.id " +
            "JOIN organization o ON ct.organization_id = o.id " +
            "JOIN region r ON o.region_id = r.id " +
            "WHERE TO_CHAR(ct.date, 'YYYY.MM') = :month " +
            "GROUP BY e.prinfl " +
            "HAVING COUNT(DISTINCT r.id) > 1", nativeQuery = true)
    List<Object[]> findPrinflWithOrgCountAndTotalSalary(@Param("month") String month);


    @Query(value = "SELECT e.first_name, e.last_name, e.prinfl, o.name AS organization_name, " +
            "AVG(ct.amount) AS avg_salary " +
            "FROM calculation_table ct " +
            "JOIN employee e ON ct.employee_id = e.id " +
            "JOIN organization o ON ct.organization_id = o.id " +
            "WHERE TO_CHAR(ct.date, 'YYYY.MM') = :month " +
            "AND (o.id = :organizationId OR o.parent = :organizationId) " +
            "GROUP BY e.first_name, e.last_name, e.prinfl, o.name",
            nativeQuery = true)
    List<Object[]> findAverageSalaryAndEmployeeDataByOrganization(@Param("month") String month, @Param("organizationId") int organizationId);

    @Query(value = "SELECT e.first_name, e.last_name, e.prinfl, " +
            "SUM(CASE WHEN ct.calculation_type = 'SALARY' THEN ct.amount ELSE 0 END) AS total_salary, " +
            "SUM(CASE WHEN ct.calculation_type = 'VACATION' THEN ct.amount ELSE 0 END) AS total_vacation " +
            "FROM calculation_table ct " +
            "JOIN employee e ON ct.employee_id = e.id " +
            "WHERE TO_CHAR(ct.date, 'YYYY.MM') = :month " +
            "GROUP BY e.first_name, e.last_name, e.prinfl", nativeQuery = true)
    List<Object[]> findSalaryAndVacationByMonth(@Param("month") String month);

}
