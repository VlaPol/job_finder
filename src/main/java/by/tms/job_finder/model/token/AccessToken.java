package by.tms.job_finder.model.token;

import by.tms.job_finder.model.account.PrincipalObject;
import lombok.Value;

@Value
public class AccessToken {

    String preparedToken;
    PrincipalObject principal;
}
