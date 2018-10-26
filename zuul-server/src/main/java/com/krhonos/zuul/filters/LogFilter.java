package com.krhonos.zuul_server.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class LogFilter extends ZuulFilter {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return false;
  }

  @Override
  public Object run() {
    HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
    log.info("**** Requête interceptée ! L'URL est : {} ", req.getRequestURL());
    return null;
  }
}
