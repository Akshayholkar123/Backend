package Api_Chaining;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;

import io.restassured.http.ContentType;
public class Driver {

	public static String path;

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//"C:\\Users\\akshay  holkar\\Desktop\\RestAssured\\bank.xlsx"
	path = args[0];


	ExcelUtility eLib = new ExcelUtility();
	int rowCount = eLib.getLastRowNum("trxn");

	for(int i=1; i<=rowCount; i++) {
	String TRANSACTION_ID_VAR = "MaharashtraBank001002"+new Random().nextInt(10000);
	String TRANSACTION_DATE_VAR = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	String TRANSACTION_AMOUNT_VAR = eLib.getDataFromExcel("trxn", i, 2);
	String PAYER_PSP_VAR = eLib.getDataFromExcel("trxn", i, 3);
	String PAYEE_PSP_VAR = eLib.getDataFromExcel("trxn", i, 4);

	String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss:SSS"));
	eLib.writedataInExcel("trxn", i, 0, TRANSACTION_ID_VAR);
	eLib.writedataInExcel("trxn", i, 1, TRANSACTION_DATE_VAR);

	String reqBody = "{\"Transaction_ID\":\"" + TRANSACTION_ID_VAR + "\",\"Transaction_Mode\":\"ONLINE\","
	+ "\"Transaction_Date\":\"" + TRANSACTION_DATE_VAR + "\",\"Transaction_Time\":\""+time+"\","
	+ "\"Transaction_Amount\":\"" + TRANSACTION_AMOUNT_VAR
	+ "\",\"Transaction_Type\":\"Transfer\",\"Description\":\"Payer to Payee transaction via online mode\",\"Currency\":\"INR\",\"Location\":\"Mumbai Maharastra\",\"Authorization_Code\":\"C123\",\"Merchant_Information\":\"Merchant Dharavi Mumbai\",\"Batch_Number\":\"06545678\",\"Recurring_Indicator\":\"yes\",\"Tax_Information\":\"GS34567S\",\"Risk_Assessment_Score\":\"199\",\"Promotion_Coupon_Code\":\"CH123\",\"Exchange_Rate\":\"67\",\"Transaction_Code\":\"TR12\",\"Notes\":\"This is a merchant transaction.\",\"Reference_Number\":\"REF991\",\"Device_Information\":\"xiomi Note11\",\"MCC\":\"M123\",\"CVM\":\"OTP\",\"Regulatory_Compliance_Information\":\"KYC\","
	+ "\"Payer_Details\":{\"Payer_PSP\":\"" + PAYER_PSP_VAR
	+ "\",\"Payer_Name\":\"Payer\",\"Bank_Account\":\"HDFC\",\"Account_Type\":\"Savings\",\"IFSC\":\"HDF01\",\"Mobile_Number\":\"9887776676\",\"Address\":\"payer_address@123\",\"Ip_Address\":\"1235@fghj\",\"Mail_Id\":\"mohoan@gmail.com\",\"Balance\":\"690000.90\"},"
	+ "\"Payee_Details\":{\"Payee_PSP\":\"" + PAYEE_PSP_VAR
	+ "\",\"Payee_Name\":\"Payee\",\"Bank_Account\":\"ICICI\",\"Account_Type\":\"Savings\",\"IFSC\":\"ICIC01\",\"Mobile_Number\":\"9886662222\",\"Address\":\"payee_address@123\",\"Mail_Id\":\"deepak.h@gmail.com\"},\"Transaction_Status\":\"Completed\",\"isUPITransaction\":true,\"Sender_Source\":\"Remitter\",\"Recipient_Destination\":\"Benificiary\"}";

	given()
	  .contentType(ContentType.JSON)
	  .body(reqBody)
	.when()
	  .post("http://49.249.29.5:8091/add-transaction")
	.then().log().all();

	}

	}
}
