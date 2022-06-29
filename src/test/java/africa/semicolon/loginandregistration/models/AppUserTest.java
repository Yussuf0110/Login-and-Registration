package africa.semicolon.loginandregistration.models;

import africa.semicolon.loginandregistration.data.models.AppUser;
import africa.semicolon.loginandregistration.data.models.AppUserRole;
import africa.semicolon.loginandregistration.data.repositories.AppUserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest
class AppUserTest {

    private AppUserRepo appUserRepo;

    @Test
    void test1(){
        AppUser appUser = new AppUser();
        appUser.setFirstName("okk");
        appUser.setEmail("google@gmail.com");
        appUser.setAppUserRole(AppUserRole.USER);

        AppUser saveUser = appUserRepo.save(appUser);
    }

}