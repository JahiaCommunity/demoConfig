/*
 * MIT License
 *
 * Copyright (c) 2002 - 2022 Jahia Solutions Group. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.huault.modules.democonfig.config.filters;

import org.huault.modules.democonfig.config.DemoConfigService;
import org.jahia.services.render.RenderContext;
import org.jahia.services.render.Resource;
import org.jahia.services.render.filter.AbstractFilter;
import org.jahia.services.render.filter.RenderChain;
import org.jahia.services.render.filter.RenderFilter;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Injects canonical and alternative urls in head element in preview and live modes.
 */
@Component(service = RenderFilter.class)
public class DemoConfigFilter extends AbstractFilter {

    private static final Logger logger = LoggerFactory.getLogger(DemoConfigFilter.class);

    private DemoConfigService configService;

    @Reference(service = DemoConfigService.class)
    public void setConfigService(DemoConfigService configService) {
        this.configService = configService;
    }

    @Activate
    public void activate() {
        setPriority(16.2f);
        setApplyOnModes("live,preview");
        setApplyOnNodeTypes("hnt:helloConfig");
        setDescription("Demo Config Service");
        logger.debug("Activated SeoUrlFilter");
    }

    @Override
    public String execute(String previousOut, RenderContext renderContext, Resource resource, RenderChain chain) throws Exception {
        try { 
        	String helloConfig = configService.helloWordConfig();
        	logger.debug("Calling filter with config "+ helloConfig +" for " + previousOut + " on " + resource.getNode());
            return previousOut.replace("$say_hello", helloConfig);
        	
        } catch (Exception e) {
			logger.error(e.getMessage(), e);
        	return previousOut;
		}
    	
        
       
    }





}
