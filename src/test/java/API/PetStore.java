package API;

import java.util.ArrayList;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PetStore {
	private int id;
    private String name;
}

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
 class Root {
    private int id;
    private PetStore category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<Tag> tags;
    private String status;
}

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Tag {
	private int id;
    private String name;
}
