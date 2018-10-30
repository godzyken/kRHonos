package com.krhonos.zuul_server.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


/**
 * <b>COMPOSANT QUI IMPLEMENTE LES FONCTIONNALITES CI-DESSOUS:</b><br/>
 *    ->LES FONCTIONNALITES DE FILTRAGE DES REQUETES HTTP RECUES PAR L'APPLICATION.<br/>
 *    <br/>
 * @author 1603599
 */
@Component
public class RequestFilter extends ZuulFilter {

	
	/**
	 * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
	 * <br/>
	 * Les fonctionnalites d'ecriture de messages de log dans la console.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestFilter.class);

	
	@Override
	public String filterType() { return "pre"; }

	@Override
	public int filterOrder() { return 1; }

	@Override
	public boolean shouldFilter() { return true; }

	@Override
	public Object run() throws ZuulException {
		
	      LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : run -- BEGIN");
	      
	      HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
	      LOGGER.info("Requete interceptee ! L'URL est : {} " , request.getRequestURL());
	      
	      LOGGER.info("CLASS : " + this.getClass().getSimpleName() + " -- METHOD : run -- END");
	      return null;
	 }
}
