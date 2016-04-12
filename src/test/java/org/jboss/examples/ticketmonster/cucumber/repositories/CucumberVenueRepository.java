package org.jboss.examples.ticketmonster.cucumber.repositories;

import java.util.ArrayList;
import java.util.List;

import org.jboss.examples.ticketmonster.interfaces.VenueRepository;
import org.jboss.examples.ticketmonster.model.Venue;
import org.jboss.examples.ticketmonster.rest.dto.VenueDTO;
import org.jboss.examples.ticketmonster.util.venue.VenueUtil;

public class CucumberVenueRepository implements VenueRepository {

	private List<Venue> venues = new ArrayList<Venue>();
	
	@Override
	public void add(VenueDTO venueDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Venue> findByCity(String cityName) {
		return VenueUtil.searchByCityName(venues, cityName);
		
	}

}
