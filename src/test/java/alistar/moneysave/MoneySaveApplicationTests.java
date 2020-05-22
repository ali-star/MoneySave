package alistar.moneysave;

import alistar.moneysave.utils.AES;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MoneySaveApplicationTests {

	@Test
	void contextLoads() {
		BearerToken token = new BearerToken(getJwt());
		String key = "altbjq*&w12%^03altbjq*&w12%^03alt";
		String encryptedToken = AES.encrypt(getJwt(), key);
		String decryptedToken = AES.decrypt(encryptedToken, key);
		System.out.println(getJwt());
		System.out.println("encrypted token: " + encryptedToken);
		System.out.println("decrypted token: " + decryptedToken);
	}

	private static String getJwt() {
		return Jwts.builder()
				.setSubject("GreetingClient") // client's identifier
				.signWith(SignatureAlgorithm.HS256, Constants.JWT_SIGNING_KEY)
				.compact();
	}

}
