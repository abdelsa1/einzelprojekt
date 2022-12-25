package ch.zhaw.einzelprojekt.security;

import java.util.List;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

import ch.zhaw.einzelprojekt.model.Studierende;
import ch.zhaw.einzelprojekt.repository.StudierendeRepository;

class UserValidator implements OAuth2TokenValidator<Jwt> {

    StudierendeRepository studierendeRepository;

    public UserValidator(StudierendeRepository studierendeRepository) {
        this.studierendeRepository = studierendeRepository;
    }

    public OAuth2TokenValidatorResult validate(Jwt jwt) {
        OAuth2Error error = new OAuth2Error("invalid_token", "The required email is missing", null);

        String userEmail = jwt.getClaimAsString("email");
        if (userEmail != null && !userEmail.equals("")) {
            if (studierendeRepository.findByEmail(userEmail).size() == 0) {
                String immatrikulationsnummer = jwt.getClaimAsString("nummer");
                String name = jwt.getClaimAsString("name");
                String vorname = jwt.getClaimAsString("vorname");
                Studierende s = new Studierende(userEmail, immatrikulationsnummer, name, vorname);
                studierendeRepository.save(s);
            }
            return OAuth2TokenValidatorResult.success();
        }
        return OAuth2TokenValidatorResult.failure(error);
    }

    public static boolean userHasRole(Jwt jwt, String requiredRole) {
        if (jwt != null) {
            List<String> userRole = jwt.getClaimAsStringList("user_roles");
            return userRole.stream().filter(x -> x.equals(requiredRole)).count() == 1;
        }
        return false;
    }
}
