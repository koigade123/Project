package com.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

public class App 
{
	 public static void main( String[] args )
	    {
	        EntityManagerFactory emf=null;
	        EntityManager em=null;
	        EntityTransaction etx=null;
	        
	        try
	        {
	    		emf = Persistence.createEntityManagerFactory("HibernateDemo");
	    		em = emf.createEntityManager();
	    		
	    		etx = em.getTransaction();
	    		etx.begin();
	    		
	    		Department department=new Department("Cardiologists");
	    		Department department1=new Department("Dentistry ");
	    		
	    		Set<Doctor> doctors = new HashSet<Doctor>();
	    		doctors.add(new Doctor("Dr.Naresh Trehan ","cardiothoracic surgeon"
	    				,"8623917281","Lucknow", department));
	    		doctors.add(new Doctor("Dr.Sudhansu Bhattacharyya","Cardiac surgeon","8623917281","Mumbai", department));
	    		doctors.add(new Doctor("Dr.Surbhi Anand","Endodontist","8623917281","Delhi", department1));
	    		
	    		
	    		Room room = new Room("Section B Room 9b");
	    		Room room1 = new Room("Section B Room 8b");
	    		Patient s1 = new Patient("Rushi","8623917281","Kurukali","21","Male",doctors,room);
	    		Patient s2 = new Patient("Prakash","8623917281","Bele","28","Male",doctors,room1);
	    		
	    		em.persist(s1);
	    		em.persist(s2);
	
	    		Bill b1=new Bill(20000, s1);
	    		Bill b2=new Bill(40000, s2);
	    		
	    		em.persist(b1);
	    		em.persist(b2);
	    		
	    		
	    		Receptionist r1=new Receptionist("Tapasya Khot",s1 );
	    		Receptionist r2=new Receptionist("Neetu Lakhyani",s2 );
	    		
	    		em.persist(r1);
	    		em.persist(r2);
	    		
	        }	
	        catch(HibernateException ex) {
	    		if(etx != null)
	    			etx.rollback();
	    		
	    		ex.printStackTrace();
	    	}
	    	finally {
	    		if(etx != null)
	    			etx.commit();
	    		
	    		if(em != null)
	    			em.close();
	    		
	    		if(emf != null)
	    			emf.close();
	    	}
	    }
}
