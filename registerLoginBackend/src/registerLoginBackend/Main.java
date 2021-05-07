package registerLoginBackend;
import java.util.List;

import registerLoginBackend.business.abstracts.UserService;
import registerLoginBackend.business.concretes.AuthManager;
import registerLoginBackend.business.concretes.EmailManager;
import registerLoginBackend.business.concretes.UserManager;
import registerLoginBackend.business.concretes.UserValidationManager;
import registerLoginBackend.core.AuthService;
import registerLoginBackend.core.GoogleLoginManagerAdapter;
import registerLoginBackend.dataAccess.concretes.InMemoryUserDao;
import registerLoginBackend.entities.concretes.User;
public class Main {

	public static void main(String[] args) {
UserService userService = new UserManager(new InMemoryUserDao());
		
		AuthService authService = new AuthManager(userService, new UserValidationManager(), new EmailManager());

		
		System.out.println("\n######### Register Tests #########");
		
		authService.register(1, "Ahmet", "trkmnglu", "serss@gmail.com", "123ahmt");
		authService.register(2, "musa", "bey", "yok", "3123");  
		authService.register(3, "Deneme", "Test", "testmail@gmail.com", "invld"); 
		authService.register(4, "I", "V", "testmail2@gmail.com", "validpassword123");  
		authService.register(5, "Email", "Exists", "cxg2520@gmail.com", "123valid123");  
		authService.register(6, "", "", "denemeuye@gmail.com", "denemeuye123");  
		
		System.out.println("\n----------------------------------------------------------------\n");
		
		authService.login("cxg2520@gmail.com", "123test123");
		userService.verifyUser(1);
		authService.login("cxg2520@gmail.com", "123test"); 
		authService.login("cxg25200@gmail.com", "123test123"); 
		authService.login("cxg2520@gmail.com", ""); 
		authService.login("", "123test123"); // 
		authService.login("cxg2520@gmail.com", "123test123"); 
		
		userService.getAll(); 
		
		
		System.out.println("\n\n\n######### Google Log in Simulation #########");
		
		AuthService googleLoginService = new GoogleLoginManagerAdapter();
		googleLoginService.register(6, "Google", "Test", "googletest@gmail.com", "googletest123");
		googleLoginService.login("googletest@gmail.com", "googletest123");
		
		
	}

	
}
