package emlakburada.util;

public class EnrolleeUtil {

	private EnrolleeUtil() {

	}

	public static boolean isValidPassword(String password, String password2) {
		return password.equals(password2);
	}

}
