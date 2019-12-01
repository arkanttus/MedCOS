package br.ufac.si.medcos.filtros;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import br.ufac.si.medcos.entidades.*;

public class PermissaoFiltro implements Filter 
{
	public void destroy()
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		String servletPath = req.getServletPath();
		String contextPath = req.getContextPath();
		
		String urlsProibidas[] = {"adicionarMedico.xhtml", "editarMedico.xhtml", "medicos.xhtml", "adicionarFuncionario.xhtml", "editarFuncionario.xhtml", "funcionarios.xhtml"};
		
		if(!servletPath.equals("/login.xhtml"))
		{
			Usuario user = (Usuario) session.getAttribute("usuarioLogado");
			
			//Se o usuário logado for um funcionário sem permissão 2 ou um médico
			if((user instanceof Funcionario && ((Funcionario)user).getPermissao() != 2) || user instanceof Medico)
			{
				for(String url : urlsProibidas)
					if(servletPath.equals("/"+url))
					{
						res.sendRedirect(contextPath+"/index.xhtml");
						return;
					}
				
				if(user instanceof Funcionario && servletPath.equals("/atenderConsulta.xhtml"))
				{
					res.sendRedirect(contextPath+"/index.xhtml");
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException
	{
	}
}