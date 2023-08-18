package by.tms.job_finder.service.auth;

import by.tms.job_finder.model.account.AccountRole;
import by.tms.job_finder.model.account.CandidatePrincipal;
import by.tms.job_finder.model.account.EmployerPrincipal;
import by.tms.job_finder.model.account.PrincipalObject;
import by.tms.job_finder.model.token.AccessToken;
import by.tms.job_finder.model.token.AccessTokenProperties;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccessTokenJwtService implements AccessTokenService {

    private final Algorithm jwtAlgorithm;
    private final JWTVerifier jwtVerifier;
    private final AccessTokenProperties props;

    private static final Instant issuedAt = Instant.now();

    @Override
    public AccessToken generate(PrincipalObject principal) {
        Instant expiresAt = issuedAt.plus(props.getLiveTime());
        String tokenValue = JWT.create()
                .withJWTId(Long.toString(new Random().nextLong()))
                .withSubject(principal.getId().toString())
                .withClaim("login", principal.getEmail())
                .withClaim("role", principal.getRole().name())
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .sign(jwtAlgorithm);
        return new AccessToken(tokenValue, principal);
    }

    @Override
    public PrincipalObject authenticate(String accessTokenValue) {
        try {
            DecodedJWT jwt = jwtVerifier.verify(accessTokenValue);
            Long accountId = jwt.getClaim("sub").as(Long.class);
            String accountLogin = jwt.getClaim("login").asString();
            AccountRole accountRole = jwt.getClaim("role").as(AccountRole.class);
            return switch (accountRole) {
                case CANDIDATE -> new CandidatePrincipal(accountId, accountLogin);
                case EMPLOYER -> new EmployerPrincipal(accountId, accountLogin);
            };

        } catch (TokenExpiredException e) {
            throw new CredentialsExpiredException("JWT is expired", e);
        } catch (JWTVerificationException e) {
            throw new BadCredentialsException("JWT is invalid", e);
        }
    }
}
