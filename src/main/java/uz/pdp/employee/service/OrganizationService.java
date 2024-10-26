package uz.pdp.employee.service;

import org.springframework.stereotype.Service;
import uz.pdp.employee.entity.Organization;
import uz.pdp.employee.repository.OrganizationRepository;

import java.util.List;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    public Organization getById(Integer id) {
        return organizationRepository.findById(id).orElse(null);
    }

    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    public void delete(Integer id) {
        organizationRepository.deleteById(id);
    }
}
