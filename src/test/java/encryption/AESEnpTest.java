package encryption;

import org.testng.annotations.Test;



import authtest.EncryptAndDecrypyUtility;

public class AESEnpTest 
{
	@Test
	public void sampleTest() throws Exception
	{
		String privateKey = "Ac03tEam@j!tu_#1";
		String data = "{\"name\":\"Akshay\",\"id\":\"1\"}"; 
		String  data1 = "{\n" +
		               "    \"name\":\"Akshay\",\n" +
		               "    \"id\":\"1\"\n" +
		               "}";

		EncryptAndDecrypyUtility ed=new EncryptAndDecrypyUtility();
	System.out.println(ed.encrypt(data,privateKey));
		System.out.println(ed.decrypt(data,privateKey));

	}

}
