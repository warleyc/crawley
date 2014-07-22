package org.shm.crawley.services;


import fi.foyt.foursquare.api.io.DefaultIOHandler;
import fi.foyt.foursquare.api.io.Method;
import fi.foyt.foursquare.api.io.Response;
import org.shm.crawley.domain.Latitude;
import org.shm.crawley.helper.MapperHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.logging.Logger;

@Service
public class FoursquareService {

    @Value("${foursquare.url:}")
    String foursquareUrl;

    private static final Logger log = Logger.getLogger(FoursquareService.class.getName());


    public Latitude searchCheckins(Locale locale) {

        Latitude latitude = null;

        DefaultIOHandler defaultIOHandler = new DefaultIOHandler();
        Response response = defaultIOHandler.fetchData(foursquareUrl, Method.GET);

        //System.out.println("ResponseContent: " + response.getResponseContent());
        if (response.getResponseCode() == 200) {
            latitude = MapperHelper.foureSquareJson2Object(response.getResponseContent(), locale);
        }
        return latitude;
    }

}
