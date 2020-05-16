package alistar.moneysave;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MoneySaveApplicationTests {

	@Test
	void contextLoads() {
		BearerToken token = new BearerToken(getJwt());
		System.out.println(getJwt());
	}

	private static String getJwt() {
		return Jwts.builder()
				.setSubject("GreetingClient") // client's identifier
				.signWith(SignatureAlgorithm.HS256, Constants.JWT_SIGNING_KEY)
				.compact();
	}

}
