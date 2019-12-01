package br.ufac.si.medcos.filtros;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import br.ufac.si.medcos.entidades.Usuario;

public class LoginFiltro implements Filter 
{
	public void destroy()
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		Usuario user = null;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession sess = req.getSession(false);
		String path = req.getServletPath();
		
		if(path.startsWith("/resources"))
			chain.doFilter(request, response);
		else
		{
			if(sess != null)
				user = (Usuario) sess.getAttribute("usuarioLogado");
			
			//System.out.println("USER = " + user);
			
			String contextPath = ((HttpServletRequest) request).getContextPath();
			if(user == null && !path.equals("/login.xhtml"))
				((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
			else if(user != null && path.equals("/login.xhtml"))
				((HttpServletResponse) response).sendRedirect(contextPath + "/index.xhtml");
			else
				chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException
	{
	}
}