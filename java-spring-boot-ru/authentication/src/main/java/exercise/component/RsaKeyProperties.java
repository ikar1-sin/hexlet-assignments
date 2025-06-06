package exercise.component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
@ConfigurationProperties(prefix = "rsa")
@Component
public class RsaKeyProperties {
    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;
}
// END
