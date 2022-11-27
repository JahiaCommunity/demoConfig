package org.huault.modules.democonfig.config.impl;

import org.huault.modules.democonfig.config.DemoConfigService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Component(service = DemoConfigService.class, immediate = true)
public class DemoConfigServiceImpl implements DemoConfigService {
    private static final Logger logger = LoggerFactory.getLogger(DemoConfigServiceImpl.class);

    private String helloWordConfig;

    @Activate
    public void activate(Map<String, ?> props)  {
    	helloWordConfig = (String) props.get("helloWordConfig");
        logger.info("Config Settings helloWord : {}", helloWordConfig);
    }

    @Deactivate
    public void deactivate() {
        logger.info("Config Settings helloWord  deactivated");
    }

	@Override
	public String helloWordConfig() {
		return helloWordConfig;
	}

}
