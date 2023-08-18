package by.tms.job_finder.service.auth;

import by.tms.job_finder.model.account.PrincipalObject;
import by.tms.job_finder.model.token.AccessToken;

public interface AccessTokenService {
    AccessToken generate(PrincipalObject principal);

    PrincipalObject authenticate(String accessTokenValue);
}