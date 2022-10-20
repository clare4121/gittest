package com.bee.sample.chl.config;



import com.bonc.sso.client.IAuthHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("ALL")
@Configuration
public class XframeAuthHandle implements IAuthHandle {
	private static final Logger log = LoggerFactory.getLogger(XframeAuthHandle.class);

	@Override
	public boolean onSuccess(HttpServletRequest request, HttpServletResponse response, String loginId) {
		if (null != request && null != loginId && loginId.trim().length() > 0) {

		}
		return true;
	}

	
}
