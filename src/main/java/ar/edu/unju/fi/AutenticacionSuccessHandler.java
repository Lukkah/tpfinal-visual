package ar.edu.unju.fi;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AutenticacionSuccessHandler implements AuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub		
		boolean tipoDB = false;
		boolean tipoAdmin = false;
		boolean tipoConsultor = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("DB")) {
				tipoDB = true;
				break;
			} else {
				if (grantedAuthority.getAuthority().equals("ADMINISTRADOR")) {
					tipoAdmin = true;
					break;
			} else {
				tipoConsultor = true;
				break;
			}
		}
		}
		if (tipoDB) {
			redirectStrategy.sendRedirect(request, response, "/gestionUsuarios");
			redirectStrategy.sendRedirect(request, response, "/gestionLocalidades");
		} else {
			if (tipoAdmin) {
				redirectStrategy.sendRedirect(request, response, "/createRegistro");
		} else {
			if (tipoConsultor) {
				redirectStrategy.sendRedirect(request, response, "/home");
			} else {
				throw new IllegalStateException();	
			}
		}			
		}
	}

}
