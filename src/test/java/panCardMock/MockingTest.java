package panCardMock;

import org.testng.Assert;

public class MockingTest 
{
	public static void main(String[] args) {
		PanCard obj = PanCard.getMockObject();
		System.out.println(obj.isvalid("ABCDE1234a"));
	//		Assert.assertEquals(obj.isvalid("ABCDE1234a"),"valid PAN card");
	}

}
