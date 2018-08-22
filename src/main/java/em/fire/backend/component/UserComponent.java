package em.fire.backend.component;
import org.springframework.stereotype.Component;

@Component("userComponent")
public class UserComponent {

	//private static final Log LOG = LogFactory.getLog(UserComponent.class);
	
	public String sayHello() {
		return "Hello Fire Component";
	}
	
}
