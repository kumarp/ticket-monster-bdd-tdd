package org.jboss.examples.ticketmonster.util.venue;

import java.util.ArrayList;
import java.util.List;

import org.jboss.examples.ticketmonster.model.Venue;

public class VenueUtil {
	
	public static List<Venue> searchByCityName( List<Venue> venues, String cityName ){
		List<Venue> venuesInCity = new ArrayList<Venue>();
		for ( Venue venue: venues ) {
			if( venue.getAddress().getCity().equals(cityName) ) {
				venuesInCity.add(venue);
			}
		}
		return venuesInCity;
	}

}
