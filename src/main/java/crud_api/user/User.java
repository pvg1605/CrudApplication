package crud_api.user;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity

@Table(name = "Users")
@EntityListeners(AuditingEntityListener.class)
 
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private String firstname;
	
	@Getter @Setter
	private String lastname;
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private Long phone;
		
	public User() {
		
	}
	public User(Integer id, String firstname, String lastname, String email, Long phone) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}
	
	
	
}
