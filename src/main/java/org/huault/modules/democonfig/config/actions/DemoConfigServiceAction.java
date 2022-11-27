package org.huault.modules.democonfig.config.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.huault.modules.democonfig.config.DemoConfigService;
import org.jahia.bin.Action;
import org.jahia.bin.ActionResult;
import org.jahia.services.content.JCRSessionWrapper;
import org.jahia.services.render.RenderContext;
import org.jahia.services.render.Resource;
import org.jahia.services.render.URLResolver;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(service = DemoConfigServiceAction.class, immediate = true)
public class DemoConfigServiceAction extends Action {

    private DemoConfigService demoConfigService;
    private static final Logger logger = LoggerFactory.getLogger(DemoConfigServiceAction.class);

    @Reference(service = DemoConfigService.class)
    public void setConfigService(DemoConfigService configService) {
        this.demoConfigService = configService;
    }
	
	
	@Activate
    public void activate() {
        setName("demoConfigServiceAction");
        setRequiredMethods("GET,POST");
        
    }

	
	@Override
	public ActionResult doExecute(HttpServletRequest req, RenderContext renderContext, final Resource resource,
            JCRSessionWrapper session, final Map<String, List<String>> parameters,
            URLResolver urlResolver) throws Exception {
		
		/*
		JSONObject response = new JSONObject();
		String helloConfig = demoConfigService.helloWordConfig();
		response.put("helloConfig", helloConfig );
		logger.info("Calling action for helloConfig {}", helloConfig); 
		return new ActionResult(HttpServletResponse.SC_OK, null, response);
		*/
		final HttpServletResponse response = renderContext.getResponse();
		String helloConfig = demoConfigService.helloWordConfig();
		logger.info("Calling action for helloConfig {}", helloConfig); 
		response.getWriter().write("Hello helloConfig Action! ");
	    return ActionResult.OK;
	}
	

}
