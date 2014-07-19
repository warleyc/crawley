package org.shm.crawley.web.controller;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.shm.crawley.services.LatitudeService;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@Inject
	LatitudeService latitudeService;

	private static final Logger logger = Logger
			.getLogger(TestController.class.getName());

	@RequestMapping("/toto.do")
	public ModelAndView home(Device device) {

		ModelAndView mav = new ModelAndView();
		if (device.isMobile()) {
			logger.info("Hello mobile user!");
			System.out.println("Hello mobile user!");
			mav.setViewName("mobile/geolocalisation");
		} else {
			logger.info("Hello desktop user!");
			System.out.println("Hello desktop user!");
			mav.setViewName("shm");
		}
		return mav;
	}



	@RequestMapping("/lang.do")
	public ModelAndView lang() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("m_local");
		return mav;
	}


	@RequestMapping("/local.do")
	public ModelAndView displayHeaderInfo2(ModelMap model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("local");
		return mav;
	}
	
	
	
}
