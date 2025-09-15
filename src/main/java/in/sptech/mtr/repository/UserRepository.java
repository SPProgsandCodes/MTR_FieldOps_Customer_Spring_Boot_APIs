package in.sptech.mtr.repository;

import in.sptech.mtr.entity.RegisterUserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<RegisterUserEntity, Long> {
    boolean existsByEmail(String email);
    Optional<RegisterUserEntity> findByEmail(String email);
}
