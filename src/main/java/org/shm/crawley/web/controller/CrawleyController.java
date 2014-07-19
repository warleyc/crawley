package org.shm.crawley.web.controller;

import org.shm.crawley.domain.Latitude;
import org.shm.crawley.services.LatitudeService;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Locale;

@Controller
public class CrawleyController {


    @Inject
    LatitudeService latitudeService;

    @RequestMapping("/")
    public String welcome(Device device) {
        if (device.isMobile()) {
            return mobile();
        } else {
            return "index";
        }
    }

    @RequestMapping("/mobile/index")
    public String mobile() {
        return "mobile/index";
    }

    @RequestMapping("/mobile/contact")
    public String contact() {
        return "mobile/contact";
    }


    @RequestMapping("/mobile/projets")
    public String projets() {
        return "mobile/projets";
    }

    @RequestMapping("/mobile/geoloc")
    public ModelAndView geolocalisation(Locale locale) {
        ModelAndView mav = new ModelAndView("mobile/geolocalisation");
        Latitude latitude = latitudeService.findLastPosition(locale);
        mav.addObject("latitude", latitude);
        return mav;
    }

}
