package SpringTest.ds_2024.service;

import SpringTest.ds_2024.entity.Property;
import SpringTest.ds_2024.entity.PropertyStatus;
import SpringTest.ds_2024.repository.PropertyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Transactional
    public List<Property> getProperties() {
        return propertyRepository.findAll();
    }

    @Transactional
    public Property getProperty(Integer property_id){
        return propertyRepository.findById(property_id).get();
    }

    @Transactional
    public void saveProperty(Property property){
        propertyRepository.save(property);
    }

    @Transactional
    public List<Property> getAvailableProperties() {
        return propertyRepository.findByStatus(PropertyStatus.AVAILABLE);
    }

    @Transactional
    public Property getPropertyById(Integer propertyId) {
        return propertyRepository.findById(propertyId).orElseThrow(() -> new IllegalArgumentException("Property not found"));
    }

    @Transactional
    public void deleteProperty(Integer propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}