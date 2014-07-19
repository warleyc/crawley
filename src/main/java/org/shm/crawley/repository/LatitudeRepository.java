package org.shm.crawley.repository;

import org.shm.crawley.domain.Latitude;

public interface LatitudeRepository {

	
	public Latitude findById(Long id) ;
	public Latitude create(Latitude o) ;
	public void update(Latitude o);
}
