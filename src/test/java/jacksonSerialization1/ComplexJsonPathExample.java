package jacksonSerialization1;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ComplexJsonPathExample {
    public static void main(String[] args) {
        String json = "{\n" +
                "  \"store\": {\n" +
                "    \"book\": [\n" +
                "      {\n" +
                "        \"category\": \"reference\",\n" +
                "        \"author\": \"Nigel Rees\",\n" +
                "        \"title\": \"Sayings of the Century\",\n" +
                "        \"price\": 8.95\n" +
                "      },\n" +
                "      {\n" +
                "        \"category\": \"fiction\",\n" +
                "        \"author\": \"Evelyn Waugh\",\n" +
                "        \"title\": \"Sword of Honour\",\n" +
                "        \"price\": 12.99\n" +
                "      }\n" +
                "    ],\n" +
                "    \"bicycle\": {\n" +
                "      \"color\": \"red\",\n" +
                "      \"price\": 19.95\n" +
                "    }\n" +
                "  }\n" +
                "}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);

            // Extracting complex JSON path
            JsonNode bookArray = rootNode.path("store").path("book");
            if (bookArray.isArray()) {
                for (JsonNode book : bookArray) {
                    String category = book.path("category").asText();
                    String author = book.path("author").asText();
                    double price = book.path("price").asDouble();

                    System.out.println("Category: " + category);
                    System.out.println("Author: " + author);
                    System.out.println("Price: " + price);
                }
            }

            // Extracting nested object
            JsonNode bicycleNode = rootNode.path("store").path("bicycle");
            String color = bicycleNode.path("color").asText();
            double bicyclePrice = bicycleNode.path("price").asDouble();

            System.out.println("Bicycle Color: " + color);
            System.out.println("Bicycle Price: " + bicyclePrice);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
