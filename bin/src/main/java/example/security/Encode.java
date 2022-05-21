package example.security;

import org.bouncycastle.crypto.generators.SCrypt;
import java.io.IOException;
import javax.xml.bind.DatatypeConverter;

public class Encode {
  private static final String SALT = "abc123";

  // DifficultyFactor
  // These should be powers of 2
  private static final int cpu = 8;
  private static final int memory = 8;
  private static final int parallelism = 8;
  private static final int outputLength = 32;

  public String hashpw(String pass){
    byte[] hash = SCrypt.generate(pass.getBytes(), SALT.getBytes(), cpu, memory, parallelism, outputLength);

    return new String(hash);
  }

  public boolean verify(String pass, String hash){

      pass = hashpw(pass);

      return pass.equals(hash);
  }
}
