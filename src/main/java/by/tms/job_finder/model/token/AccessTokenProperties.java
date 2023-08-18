package by.tms.job_finder.model.token;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "jobfinder.access-token")
@Value
public class AccessTokenProperties {
    String secret;
    Duration liveTime;
}
