package emlakburada.entity;

import javax.persistence.*;

import emlakburada.entity.enums.EnrolleeType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Enrollee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enrolleeId;
	@Enumerated(EnumType.STRING)
	EnrolleeType enrolleeType;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;

	public Enrollee(String email){
		this.email=email;
	}

	public Enrollee(){}

}
