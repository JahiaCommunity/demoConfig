/*
 * ==========================================================================================
 * =                            JAHIA'S ENTERPRISE DISTRIBUTION                             =
 * ==========================================================================================
 *
 *                                  http://www.jahia.com
 *
 * JAHIA'S ENTERPRISE DISTRIBUTIONS LICENSING - IMPORTANT INFORMATION
 * ==========================================================================================
 *
 *     Copyright (C) 2002-2022 Jahia Solutions Group. All rights reserved.
 *
 *     This file is part of a Jahia's Enterprise Distribution.
 *
 *     Jahia's Enterprise Distributions must be used in accordance with the terms
 *     contained in the Jahia Solutions Group Terms &amp; Conditions as well as
 *     the Jahia Sustainable Enterprise License (JSEL).
 *
 *     For questions regarding licensing, support, production usage...
 *     please contact our team at sales@jahia.com or go to http://www.jahia.com/license.
 *
 * ==========================================================================================
 */
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
		// TODO Auto-generated method stub
		return null;
	}

}
