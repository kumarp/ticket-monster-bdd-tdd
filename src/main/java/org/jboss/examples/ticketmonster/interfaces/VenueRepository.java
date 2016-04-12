package org.jboss.examples.ticketmonster.interfaces;

import java.util.List;

import org.jboss.examples.ticketmonster.model.Venue;
import org.jboss.examples.ticketmonster.rest.dto.VenueDTO;

public interface VenueRepository {
	
	public void add (VenueDTO venueDto);
	
	public List<Venue> findByCity (String cityName);
	
}