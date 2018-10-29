package sbt.bookpub;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.net.SSLHostConfig;
import org.apache.tomcat.util.net.SSLHostConfigCertificate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:tomcat.https.properties")
@ConfigurationProperties(prefix = "custom.tomcat.https")
public class TomcatSslConnectorProperties {

    private Integer port ;
    private Boolean ssl ;
    private Boolean secure ;
    private String scheme ;
    private String keystoreFile;
    private String keystorePassword ;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Boolean getSsl() {
        return ssl;
    }

    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
    }

    public Boolean getSecure() {
        return secure;
    }

    public void setSecure(Boolean secure) {
        this.secure = secure;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getKeystoreFile() {
        return keystoreFile;
    }

    public void setKeystoreFile(String keystoreFile) {
        this.keystoreFile = keystoreFile;
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public void setKeystorePassword(String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }

    public void configureConnector(Connector connector) {
        if (null != port) {
            connector.setPort(port);
        }
        if (null != ssl) {
            connector.setProperty("SSLEnabled", Boolean.toString(ssl));
        }
        if (null != secure) {
            connector.setSecure(secure);
        }
        if (null != scheme) {
            connector.setScheme(scheme);
        }
        if (null != keystoreFile) {
            SSLHostConfig config = new SSLHostConfig();

            SSLHostConfigCertificate configCertificate = new SSLHostConfigCertificate(config, SSLHostConfigCertificate.Type.RSA);
            configCertificate.setCertificateKeystoreFile(keystoreFile);
            configCertificate.setCertificateKeystorePassword(keystorePassword);

            config.addCertificate(configCertificate);

            connector.addSslHostConfig(config);
        }
    }
}
