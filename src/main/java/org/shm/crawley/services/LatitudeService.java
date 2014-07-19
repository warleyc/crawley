package org.shm.crawley.services;

import java.util.Collections;
import java.util.Locale;
import java.util.logging.Logger;

import javax.inject.Inject;


import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheManager;

import org.shm.crawley.domain.Latitude;
import org.shm.crawley.helper.MapperHelper;
import org.shm.crawley.repository.LatitudeRepository;
import org.springframework.stereotype.Service;



@Service
public class LatitudeService {

	private static final Logger log = Logger.getLogger(LatitudeService.class
			.getName());

	@Inject
	LatitudeRepository latitudeRepository;

	@Inject
	MapperHelper mapperHelper;

	//@Inject
	Cache cache;

    @Inject
    FoursquareService foursquareService;

	static final Long UID = (long) 5654;

    /**
     *
     * @param o
     */
	private void saveLatitude(Latitude o) {
		o.setId(UID);
		latitudeRepository.create(o);
		addLatitudeInCache(o);
	}


	private Latitude getLatitudeFromCache() {
		checkCache();
		return  (Latitude) cache.get(UID);
	}

	private void addLatitudeInCache(Latitude latitude) {
		// utilisqation de mem cache??
		// un process pour sauver mem cache?
		checkCache();

		cache.put(UID, latitude);

	}

	private void checkCache() {
		if (cache == null) {
			try {
				cache = CacheManager.getInstance().getCacheFactory()
						.createCache(Collections.emptyMap());
			} catch (CacheException e) {
				log.severe("probleme sur la gestion du cache"+e.getMessage());
			}
		}
	}



    public Latitude findLastPosition(Locale locale) {
        log.info("findLastPositionV4 Begin");
        Latitude  newLatitude=foursquareService.searchCheckins(locale);


        if (newLatitude!=null) {
            saveLatitude(newLatitude);
        } else {
            newLatitude = getLatitudeFromCache();

            log.info("latitude from cache" + newLatitude);
            if (newLatitude == null) {
                newLatitude = latitudeRepository.findById(UID);
                log.info("latitude from database=" + newLatitude);
                addLatitudeInCache(newLatitude);

            }

            // update since
            if (newLatitude!=null && newLatitude.getTimeStamp() != null) {
                newLatitude.setSince(MapperHelper.getPrettyTime(newLatitude
                        .getTimeStamp(),locale));
            }

        }

        return newLatitude;

    }



}
