package panCardMock;

import org.mockito.Mockito;

public class PanCard {

//	public static void main(String[] args) 
//	{
//		System.out.println(PanCard.isvalid("ABCHO1234A"));
//
//	}
	public String isvalid(String panCard)
	{
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true)
		{
			return "is a valid panCard";
		}
		else 
		{
			return "invalid panCard number please enter again";

			
		}}
		public static PanCard getMockObject()
		{
			PanCard mocObj=Mockito.mock(PanCard.class);
			Mockito.when(mocObj.isvalid("ABCDE1234A")).thenReturn("valid PAN card");
			Mockito.when(mocObj.isvalid("ABCDE1234C")).thenReturn("invalid PAN card");
			Mockito.when(mocObj.isvalid("ABCDE1234B")).thenReturn("valid PAN card");

      return mocObj;
		}
	

}
