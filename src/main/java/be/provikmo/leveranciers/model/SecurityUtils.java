/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Glenn Lefevere
 *
 */
public final class SecurityUtils {

	/** The Constant DEFAULT_USERID. */
	public static final String DEFAULT_USERID = "NA";

	/**
	 * Private Constructor
	 */
	private SecurityUtils() {
	}

	/**
	 * Test if the current user has certain role. If no {@link Authentication} should be present on the
	 * 
	 * @param role
	 *            The role that should be verified
	 * @return true if the current user has the role, false otherwise.
	 *         {@link org.springframework.security.core.context.SecurityContext} , then false will be returned.
	 */
	public static boolean hasRole(String role) {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		if (currentUser != null) {
			for (GrantedAuthority grantedAuthority : currentUser.getAuthorities()) {
				if (grantedAuthority.getAuthority().equals(role)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Gets the authentication.
	 * 
	 * @return the authentication
	 */
	public static Authentication getAuthentication() {

		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * Gets the user id.
	 * 
	 * @return the user id
	 */
	public static String getUserId() {
		final Authentication auth = getAuthentication();

		String userId = null;
		if (auth != null) {
			userId = auth.getName();
		}
		return userId;
	}

	/**
	 * Gets the user details.
	 * 
	 * @return the user details
	 */
	public static Userdetails getUserdetails() {
		final Authentication auth = getAuthentication();
		Userdetails userDetails = null;
		if (auth != null && auth.getDetails() instanceof Userdetails) {
			userDetails = (Userdetails) auth.getDetails();
		}
		return userDetails;
	}

	/**
	 * Checks if an anonymous user is on the security context.
	 * 
	 * @return true if it is an anonymous user, false otherwise
	 */
	public static Boolean isAnonymousUser() {
		return getAuthentication() instanceof AnonymousAuthenticationToken;
	}

}
