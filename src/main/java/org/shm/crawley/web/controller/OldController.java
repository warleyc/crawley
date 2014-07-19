package org.shm.crawley.web.controller;

import org.shm.crawley.domain.Latitude;
import org.shm.crawley.services.LatitudeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Locale;

/**
 * Created by crawleyn on 15/04/2014.
 */
@Controller
public class OldController {


    @Inject
    LatitudeService latitudeService;

    @RequestMapping("/index.do")
    public ModelAndView index(ModelMap model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/shm.do")
    public ModelAndView shm(ModelMap model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("shm");
        return mav;
    }




    @RequestMapping("/mobile/shm.do")
    public ModelAndView shmMobile(ModelMap model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("mobile/shm");
        return mav;
    }

    @RequestMapping("/mobile/geoloc.do")
    public ModelAndView geolocalisation(Locale locale) {
        ModelAndView mav = new ModelAndView("mobile/geolocalisation");
        Latitude latitude = latitudeService.findLastPosition(locale);
        mav.addObject("latitude", latitude);
        return mav;
    }

      @RequestMapping("/updateLocation.do")
    public ModelAndView updatelocation(Locale locale) {
        ModelAndView mav = new ModelAndView("mobile/geolocalisation");
        Latitude latitude = latitudeService.findLastPosition(locale);
        mav.addObject("latitude", latitude);
        return mav;
    }


}
