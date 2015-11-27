/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.airportservicelayer.facade;

import cz.muni.fi.airport.entity.Airplane;
import cz.muni.fi.airport.entity.Destination;
import cz.muni.fi.airport.entity.Flight;
import cz.muni.fi.airportapi.dto.DestinationDTO;
import cz.muni.fi.airportapi.dto.FlightCreationalDTO;
import cz.muni.fi.airportapi.dto.FlightDTO;
import cz.muni.fi.airportapi.dto.UpdateFlightsAirplaneDTO;
import cz.muni.fi.airportapi.dto.UpdateFlightArrivalDTO;
import cz.muni.fi.airportapi.dto.UpdateFlightDepartureDTO;
import cz.muni.fi.airportapi.dto.UpdateFlightDestinationDTO;
import cz.muni.fi.airportapi.dto.UpdateFlightOriginDTO;
import cz.muni.fi.airportapi.facade.FlightFacade;
import cz.muni.fi.airportservicelayer.services.AirplaneService;
import cz.muni.fi.airportservicelayer.services.BeanMappingService;
import cz.muni.fi.airportservicelayer.services.DestinationService;
import cz.muni.fi.airportservicelayer.services.FlightService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gabriela Podolnikova
 */
@Service
@Transactional
public class FlightFacadeImpl implements FlightFacade {
    
    @Autowired
    private FlightService flightService;
    
    @Autowired
    private DestinationService destinationService;
    
    @Autowired
    private AirplaneService airplaneService;
    
    @Autowired
    private BeanMappingService beanMappingservice;
    
    @Override
    public FlightDTO getFlightWithId(Long id) {
        Flight flight = flightService.findById(id);
        if (flight == null) {
            return null;
        }
        return beanMappingservice.mapTo(flight, FlightDTO.class);
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        return beanMappingservice.mapTo(flightService.findAll(), FlightDTO.class);
    }

    @Override
    public List<FlightDTO> getFlightsByDate(boolean arrival) {
        return beanMappingservice.mapTo(flightService.listByDate(arrival), FlightDTO.class);
    }

    @Override
    public Long createFlight(FlightCreationalDTO f) {
        Flight mappedF = beanMappingservice.mapTo(f, Flight.class);
        flightService.create(mappedF);
        return mappedF.getId();
    }

    @Override
    public void removeFlight(Long id) {
        flightService.delete(flightService.findById(id));
    }

    @Override
    public void updateFlightArrival(UpdateFlightArrivalDTO update) {
        Flight f = flightService.findById(update.getId());
        f.setArrival(update.getArrival());
        flightService.update(f);
    }

    @Override
    public void updateFlightDeparture(UpdateFlightDepartureDTO update) {
        Flight f = flightService.findById(update.getId());
        f.setDeparture(update.getDeparture());
        flightService.update(f);
    }

    @Override
    public void updateFlightDestination(UpdateFlightDestinationDTO update) {
        Flight f = flightService.findById(update.getId());
        Destination d = destinationService.findById(update.getId());
        f.setDestination(d);
        flightService.update(f);
    }

    @Override
    public void updateFlightOrigin(UpdateFlightOriginDTO update) {
        Flight f = flightService.findById(update.getId());
        Destination d = destinationService.findById(update.getId());
        f.setOrigin(d);
        flightService.update(f);
    }

    @Override
    public void updateFlightAirplane(UpdateFlightsAirplaneDTO update) {
        Flight f = flightService.findById(update.getId());
        Airplane a = airplaneService.findById(update.getId());
        f.setAirplane(a);
        flightService.update(f);
    }

    @Override
    public List<FlightDTO> getFlightsByOrigin(DestinationDTO origin) {
        return beanMappingservice.mapTo(flightService.listByOrigin(origin.getId()), FlightDTO.class);
    }

    @Override
    public List<FlightDTO> getFlightsByDestination(DestinationDTO destination) {
        return beanMappingservice.mapTo(flightService.listByDestination(destination.getId()), FlightDTO.class);
    }
}
