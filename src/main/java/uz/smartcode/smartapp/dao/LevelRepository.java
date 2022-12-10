package uz.smartcode.smartapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.smartcode.smartapp.entity.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {
    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Integer id);
}