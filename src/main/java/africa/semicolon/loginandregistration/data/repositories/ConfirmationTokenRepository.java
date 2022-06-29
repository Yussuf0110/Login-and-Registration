package africa.semicolon.loginandregistration.data.repositories;

import africa.semicolon.loginandregistration.data.models.ConfirmationToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ConfirmationTokenRepository extends MongoRepository<ConfirmationToken,String> {

    Optional<ConfirmationToken> findByToken(String token);

    @Transactional
    @Query("UPDATE ConfirmationToken c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
    String updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);


}
