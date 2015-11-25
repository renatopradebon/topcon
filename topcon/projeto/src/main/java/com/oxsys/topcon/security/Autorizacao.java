package com.oxsys.topcon.security;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oxsys.topcon.model.Usuario;
import com.oxsys.topcon.repository.UsuarioRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
 

@RestController
public class Autorizacao {

	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	@RequestMapping("/whoami")
	public String whoAmI(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = "R: " + request.getRemoteAddr();
		}
		return ipAddress;
	}

	
	@RequestMapping(value = "/autenticar", method = RequestMethod.POST)
	public boolean autenticaUsuario(HttpServletRequest request, @RequestBody Usuario pessoa) {

		//String ipAddress = request.getHeader("X-FORWARDED-FOR");
		//if (ipAddress == null) {
		//	ipAddress = "R: " + request.getRemoteAddr();
		//}
		return usuarioAutorizado(pessoa);
	}

	
	
	@RequestMapping(value = "/autenticaToken", method = RequestMethod.POST)
	public LoginResponse autenticaUsuarioRetornaToken(HttpServletRequest request,
			@RequestBody Usuario participante) throws IOException, ServletException {

		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = "R: " + request.getRemoteAddr();
		}

		Usuario participanteEncontrado = 
				usuarioRepository.findByNomeIgnoreCase(participante.getNome());
		
		if (participanteEncontrado != null && 
					participante.getSenha().equals(participanteEncontrado.getSenha()) ) {

			try {

				return new LoginResponse( 
				Jwts.builder()
				.setSubject(participanteEncontrado.getNome())
				.claim("roles", participanteEncontrado.getAdmin().toString()).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "lyndontavares").compact());

			} catch (final SignatureException e) {
				throw new ServletException("Invalid token.");
			}

		}

		return null;
	}


	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "role/{role}", method = RequestMethod.GET)
	public Boolean role(@PathVariable final String role,
			final HttpServletRequest request) throws ServletException {
		final Claims claims = (Claims) request.getAttribute("claims");

		List<String> list = (List<String>) claims.get("roles");
		return list.contains(role);
	}
	
	
	private boolean usuarioAutorizado(Usuario participante) {
		boolean ret = false;
		Usuario p = usuarioRepository.findByNomeIgnoreCase(participante.getNome());
		if (p != null) {
			ret = participante.getSenha().equals(p.getSenha());
		}
		return ret;
	}


	@SuppressWarnings("unused")
	private static class LoginResponse {
		public String token;

		public LoginResponse(final String token) {
			this.token = token;
		}
	}
}
