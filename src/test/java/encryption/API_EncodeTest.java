package encryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class API_EncodeTest
{
	@Test
	public void sampletest()
	{
		String encodeData=new String(Base64.getEncoder().encode("rmgyantra:rmgy@9999".getBytes()));
		System.out.println(encodeData);
		String decodedata=new String(Base64.getDecoder().decode(encodeData.getBytes()));
		System.out.println(decodedata);

		String decodeData=new String(Base64.getDecoder().decode("cm1neWFudHJhOnJtZ3lAOTk5OQ==".getBytes()));
		System.out.println(decodeData);
		
		
		
	}

}
