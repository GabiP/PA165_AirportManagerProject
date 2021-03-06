/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.airport.dao;

import cz.muni.fi.airport.entity.Airplane;
import cz.muni.fi.airport.entity.Destination;
import cz.muni.fi.airport.entity.Flight;
import cz.muni.fi.airport.entity.Steward;
import java.util.Date;
import java.util.List;

/**
 * Interface Data Acces Object for the entity Flight
 * 
 * @author Gabriela Podolnikova
 */
public interface FlightDao {
    
    /**
     * Creates new entity of Flight
     * @param f flight to be persisted
     */
    public void create(Flight f);
    
    /**
     * Deletes the entity of Flight
     * @param f flight to be deleted
     */
    public void delete(Flight f);
    
    /**
     * Update the entity of Flight
     * @param f flight to be updated
     * @return the instance of flight that was updated with merged changes
     */
    public Flight update(Flight f);
    
    /**
     * Finds the entity of flight by its ID
     * @param id identificator of flight
     * @return flight with given ID
     */
    public Flight findById(Long id);
    
    /**
     * Lists all persisted flights entities
     * @return all flight entities
     */
    public List<Flight> findAll();
    
    /**
     * Lists all persisted flights entities sorted by date
     * @param arrival if true sorted by arrival date otherwise sorted by departure
     * @return all flight entities sorted by date
     */
    public List<Flight> listByDate(boolean arrival);
    
    /**
     * Lists all persisted flights entities departing from the origin
     * @param origin the destination origin that the flight is listed by 
     * @return all flight entities sorted by origin
     */
    public List<Flight> listByOrigin(Long id);
    
    /**
     * Lists all persisted flights entities departing to the destination
     * @param destination the destination that the flight is listed by 
     * @return all flight entities sorted by destination
     */
    public List<Flight> listByDestination(Long id);
    
}
