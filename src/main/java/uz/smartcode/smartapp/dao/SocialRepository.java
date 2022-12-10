package uz.smartcode.smartapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.smartcode.smartapp.entity.Social;

import java.util.Optional;
import java.util.UUID;

public interface SocialRepository extends JpaRepository<Social, Integer> {
    Optional<Social> findAllByUserId(UUID user_id);
}