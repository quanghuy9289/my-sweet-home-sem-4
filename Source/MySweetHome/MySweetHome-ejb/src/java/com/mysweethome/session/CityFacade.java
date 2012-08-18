/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysweethome.session;

import com.mysweethome.entity.City;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LongVu
 */
@Stateless
public class CityFacade extends AbstractFacade<City> {
    @PersistenceContext(unitName = "MySweetHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CityFacade() {
        super(City.class);
    }
    
    @Override
    public void create(City city) {
        em.persist(city);
    }

    @Override
    public void edit(City city) {
        em.merge(city);
    }

    @Override
    public void remove(City city) {
        em.remove(em.merge(city));
    }

    public City getCityID(String cityID){
        City ct=null;
        try{
            Query query=em.createNamedQuery("City.findByCityID");
            query.setParameter("cityID", cityID);
            ct=(City) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ct;
    }
    public City getCityName(String cityName){
        City ct=null;
        try{
            Query query=em.createNamedQuery("City.findByCityID");
            query.setParameter("cityID", cityName);
            ct=(City) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ct;
    }
    

}
