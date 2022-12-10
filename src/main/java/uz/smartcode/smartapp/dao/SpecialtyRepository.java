package uz.smartcode.smartapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.smartcode.smartapp.entity.Specialty;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {

    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Integer id);
}