package API;

package API;

import java.util.ArrayList;

public class Runner1 {

    public static void main(String[] args) {
        // Create PetStore object
        PetStore petStore = new PetStore(1, "Pet Category");

        // Create a list of photo URLs
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://example.com/photo1");
        photoUrls.add("https://example.com/photo2");

        // Create a list of Tag objects
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(new Tag(101, "Tag1"));
        tags.add(new Tag(102, "Tag2"));

        // Create Root object and set values
        Root root = new Root();
        root.setId(123);
        root.setCategory(petStore);
        root.setName("Dog");
        root.setPhotoUrls(photoUrls);
        root.setTags(tags);
        root.setStatus("available");

        // Print the Root object using the toString method
        System.out.println(root);
    }
}
