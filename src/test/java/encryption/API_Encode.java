package encryption;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class API_Encode {
	@Test
	public void encodeTest() {
	given()
	.auth().preemptive().basic("rmgyantra","rmgy@9999")

	.log().all()
	.when()
	.get("http://49.249.29.5:8091/projects")
	.then()
	.statusCode(200)
	.log().all();


}}
