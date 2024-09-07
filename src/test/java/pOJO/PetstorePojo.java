package pOJO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class PetstorePojo {

	private int id;
	private String name;
	private String status;
	private String[] photoUrls;
	private List<Tags>  tags;

	private Category category;

}
