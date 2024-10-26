package uz.pdp.employee.service;

import org.springframework.stereotype.Service;
import uz.pdp.employee.entity.Region;
import uz.pdp.employee.repository.RegionRepository;

import java.util.List;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    public Region getById(Integer id) {
        return regionRepository.findById(id).orElse(null);
    }

    public Region save(Region region) {
        return regionRepository.save(region);
    }

    public void delete(Integer id) {
        regionRepository.deleteById(id);
    }
}
