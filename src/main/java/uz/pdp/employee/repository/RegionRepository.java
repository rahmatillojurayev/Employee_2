package uz.pdp.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.employee.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}