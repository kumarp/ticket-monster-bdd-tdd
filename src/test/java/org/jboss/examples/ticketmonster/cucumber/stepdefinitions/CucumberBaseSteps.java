package org.jboss.examples.ticketmonster.cucumber.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.examples.ticketmonster.rest.dto.AddressDTO;
import org.jboss.examples.ticketmonster.rest.dto.VenueDTO;
import org.jboss.examples.ticketmonster.cucumber.repositories.CucumberVenueRepository;
import org.jboss.examples.ticketmonster.interfaces.VenueRepository;
import org.jboss.examples.ticketmonster.model.Address;
import org.jboss.examples.ticketmonster.model.Venue;
import org.jboss.examples.ticketmonster.rest.VenueService;
import org.jboss.examples.ticketmonster.rest.VenueEndpoint;
import org.junit.Rule;
import org.mockito.AdditionalMatchers;
import org.mockito.Mockito;
import org.powermock.modules.junit4.rule.PowerMockRule;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CucumberBaseSteps {
	
	List<Venue> searchResponse = null;
	
    @Rule
    public PowerMockRule rule = new PowerMockRule();
    
    private VenueRepository venueRepository = new CucumberVenueRepository();
    
	@Given("^a list of venues$")
	public void a_list_of_venues() throws Throwable {
		Venue venue = new Venue();
		
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setStreet("4 Yawkey Way");
		addressDTO.setCountry("USA");
		addressDTO.setCity("Boston");
	
		
		VenueDTO venueDTO = new VenueDTO();
		venueDTO.setAddress(addressDTO);
		venueDTO.setName("Fenway Park");
		
		venueRepository.add(venueDTO);
	}
	
	
	// This should actually set it up so that there are no venues for this city, meaning we actually erase them
	@Given("^\"([^\"]*)\" has no venues$")
	public void has_no_venues(String cityName) throws Throwable {
//		Mockito.when(venueService.findByCityName(AdditionalMatchers.not(org.mockito.Matchers.eq("Boston")))).thenReturn(Response.status(404).build());
//
//		Response cityWithNoVenues = venueService.findByCityName(cityName);
//		assertNotNull(cityWithNoVenues);
//        int responseStatus = cityWithNoVenues.getStatus();
//        assertEquals("This city isn't supposed to have venues!", Status.NOT_FOUND.getStatusCode(), responseStatus);
	}
	

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String cityName) throws Throwable {
		searchResponse = venueRepository.findByCity(cityName);
	}
	
	
	@When("^I add \"([^\"]*)\" to \"([^\"]*)\"$")
	public void i_add_to(String venueName, String cityName) throws Throwable {
//	     // This will hit the service to actually add the venue
//		Response addToCityResponse = venueService.addVenueToCity(cityName, venueName);
//		assertNotNull(addToCityResponse);
//		assertEquals("Could not add the venue to the city!", Status.CREATED, addToCityResponse.getStatus() );
		
	}
	

	@Then("^I should receive details about the \"([^\"]*)\" venues$")
	public void i_should_receive_details_about_the_venues(String cityName) throws Throwable {
		assertNotNull(searchResponse);
		for( Venue venue : searchResponse ) {
			assertEquals( venue.getAddress().getCity(), cityName ); 
		}
	}
	
	@Then("^I should receive no results$")
	public void i_should_receive_no_results() throws Throwable {
//		assertNotNull(searchResponse);
//        assertEquals("Expected no venues, but found one!", Status.NOT_FOUND.getStatusCode(), searchResponse.getStatus() );
	}

}
