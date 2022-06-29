package africa.semicolon.loginandregistration.data.repositories;

import africa.semicolon.loginandregistration.data.models.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public interface AppUserRepo extends MongoRepository<AppUser, String> {
    Optional<AppUser> findAppUserByEmail(String email);

    @Transactional
    @Query("UPDATE AppUser a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}
