package uz.pdp.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.employee.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}