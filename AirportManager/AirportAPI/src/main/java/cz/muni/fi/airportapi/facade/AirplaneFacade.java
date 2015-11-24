/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.airportapi.facade;

import cz.muni.fi.airportapi.dto.AirplaneCreationalDTO;
import cz.muni.fi.airportapi.dto.AirplaneDTO;
import cz.muni.fi.airportapi.dto.FlightDTO;
import cz.muni.fi.airportapi.dto.UpdateAirplaneCapacityDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jakub Stromský
 */
public interface AirplaneFacade {
    public AirplaneDTO getAirplaneWithId(Long id);
    public List<AirplaneDTO> getAllAirplanes();
    public List<AirplaneDTO> getAirplaneWithName(String name);
    public void createAirplane(AirplaneCreationalDTO a);
    public void removeAirplane(Long id);
    public void updateAirplaneCapacity(UpdateAirplaneCapacityDTO update);
    public List<AirplaneDTO> getAvailableAirplanes(Date from, Date to);
    public List<FlightDTO> getAirplaneFlights(Long id);
    public List<AirplaneDTO> getSpecificAirplanes(Date from, Date to, int capacity, String location);
}
