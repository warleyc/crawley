package org.shm.crawley.web.rest;

import org.shm.crawley.domain.Latitude;
import org.shm.crawley.services.LatitudeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Locale;
import java.util.logging.Logger;

@Controller
public class LatitudeRessource {

    private static final Logger log = Logger.getLogger(LatitudeRessource.class.getName());

    @Inject
    LatitudeService latitudeService;

    /**
     * @param locale
     * @return
     */
    @RequestMapping(value = "/rest/latitude", method = RequestMethod.GET)
    @ResponseBody
    public Latitude findLastPosition(Locale locale) {
        log.info("findLastPosition()");
        Latitude newLatitude;
        newLatitude = latitudeService.findLastPosition(locale);
        return newLatitude;

    }
}
