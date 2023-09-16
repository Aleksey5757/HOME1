package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfig {
  public final String env;
  public final String baseUrl;
  public final String baseUrlUXCr;
  public final String username;
  public final String usernameCL;
  public final String userPassword;
  public final String userPasswordCL;

  public final String usernameN;

  private static final String ENV_NAME = "ACTIVE_ENVIRONMENT";

  public ApplicationConfig() {
    String getenv = System.getenv(ENV_NAME);
    if (getenv == null) env = "default";
    else env = getenv;
    Properties properties = parseProperties();
    this.baseUrl = properties.getProperty("base.url");
    this.baseUrlUXCr = properties.getProperty("base.url.UXCr");
    this.username =  properties.getProperty("user.login");
    this.userPassword = properties.getProperty("user.password");
    this.usernameN = properties.getProperty("user.login.N");
    this.usernameCL = properties.getProperty("user.login.Cl");
    this.userPasswordCL = properties.getProperty("user.password.Cl");

  }

  public Properties parseProperties() {

    try (InputStream inputStream = getClass().getClassLoader().getResource(env + ".properties")
            .openStream()
    ) {
      Properties properties = new Properties();
      properties.load(inputStream);
      return properties;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
