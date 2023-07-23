package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface UserConfig extends Config {

    @Key("username")
    String getUsername();

    @Key("jobName")
    String getJobName();

    @Key("email")
    String getEmail();

    @Key("password")
    String getPassword();
}
