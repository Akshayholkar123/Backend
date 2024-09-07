package ShoppersStack;
//import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SetDataToExcel extends BSClass{
    public static void main(String[] args) throws EncryptedDocumentException, IOException {
        Response response = given()
                .spec(requestSpec)
                                .when()
                                .post()
                                .then()
                                .statusCode(200)
                                .extract()
                                .response();
        
        String msg = response.jsonPath().getString("message");
        FileInputStream fis=new FileInputStream("excelPath");
        Workbook wb=WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet("Sheet1");
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        
        cell.setCellValue(msg);
        
        try (FileOutputStream fileOut = new FileOutputStream("excelPath")) {
            wb.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(msg);
    }
}
