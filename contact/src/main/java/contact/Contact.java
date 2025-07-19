package contact;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Contact {
	private int id;
	private String name;
	private String phonenumber;
	private String email;
	private String address;
	private String memo;
}
