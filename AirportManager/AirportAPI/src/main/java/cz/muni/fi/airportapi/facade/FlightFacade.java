/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.airportapi.facade;

import cz.muni.fi.airport.entity.Destination;
import cz.muni.fi.airportapi.dto.DestinationDTO;
import cz.muni.fi.airportapi.dto.FlightCreationalDTO;
import cz.muni.fi.airportapi.dto.FlightDTO;
import cz.muni.fi.airportapi.dto.UpdateFlightsAirplaneDTO;
import cz.muni.fi.airportapi.dto.UpdateFlightArrivalDTO;
import cz.muni.fi.airportapi.dto.UpdateFlightDTO;
import cz.muni.fi.airportapi.dto.UpdateFlightDepartureDTO;
import cz.muni.fi.airportapi.dto.UpdateFlightDestinationDTO;
import cz.muni.fi.airportapi.dto.UpdateFlightOriginDTO;
import cz.muni.fi.airportapi.dto.UpdateFlightStewardsDTO;
import java.util.List;

/**
 *
 * @author Gabriela Podolnikova
 */
public interface FlightFacade {
    
    /**
     * Gets Flight DTO with given id.
     * 
     * @param id identificator of flight
     * @return FlightDTO mapped
     */
    public FlightDTO getFlightWithId(Long id);
    
    /**
     * Lists all flights.
     * 
     * @return lists of all flights
     */
    public List<FlightDTO> getAllFlights();
    
    /**
     * Lists all flights by date.
     * 
     * @param arrival if true that the flight are sorted by arrival, if false then its sorted by departure
     * @return list of flights
     */
    public List<FlightDTO> getFlightsByDate(boolean arrival);
    
    /**
     * Creates flight with given CreationalDTO.
     * 
     * @param f to be mapped
     * @return id of mapped instance of Flight
     */
    public Long createFlight(FlightCreationalDTO f);
    
    /**
     * Removes Fligt.
     * 
     * @param id given id of FLight to be removed 
     */
    public void removeFlight(Long id);
    
    /**
     * Updates Flight.
     * 
     * @param update Flight with updated arrival time 
     */
    public void updateFlightArrival(UpdateFlightDTO update);
    
    /**
     * Updates Flight.
     * 
     * @param update Flight with updated departure time 
     */
    public void updateFlightDeparture(UpdateFlightDTO update);
    
    /**
     * Updates Flight
     * 
     * @param update Flight with updated destination 
     */
    public void updateFlightDestination(UpdateFlightDTO update);
    
    /**
     * Updates Flight
     * 
     * @param update Flight with updated origin destination 
     */
    public void updateFlightOrigin(UpdateFlightDTO update);
    
    /**
     * Updates Flight
     * 
     * @param update Flight with updated airplane
     */
    public void updateFlightAirplane(UpdateFlightDTO update);
    
    /**
     * Updates Flight
     * 
     * @param update Flight with updated stewards
     */
    public void updateFlightStewards(UpdateFlightDTO update);
    
    /**
     * Gets Flight Update DTO with given id.
     * @param id identificator
     * @return 
     */
    public UpdateFlightDTO getUpdateFlightWithId(Long id);
    
    /**
     * Lists Flights by origin location.
     * 
     * @param origin Destination to be sorted by.
     * @return list of flights flying from given origin
     */
    public List<FlightDTO> getFlightsByOrigin(DestinationDTO origin);
    
    /**
     * Lists Flights by destination.
     * 
     * @param destination Destination to be sorted by.
     * @return list of flights flying to given destination
     */
    public List<FlightDTO> getFlightsByDestination(DestinationDTO destination);
    
    /**
     * Verifies, if flight's Airplane is Available at given place at set time period
     * @param flight flight to be checked
     * @return true, if plane is available (or null), else false
     */
    public boolean verifyAirplane(FlightDTO flight);
    
    /**
     * Verifies, if flight's Stewards are Available at given place at set time period
     * @param flight flight to be checked
     * @return true, if stewards are available (or empty), else false
     */
    public boolean verifyStewards(FlightDTO flight);
    
}
