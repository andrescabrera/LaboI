/*
 * Created on 19/05/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.palermo.as2.main;

import edu.palermo.as2.service.PersonasService;
import edu.palermo.as2.service.ServiceException;

/**
 * @author Claudioz
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Main {
	
	public Main() {
		
		try {
			PersonasService ps = new PersonasService();
			System.out.println(ps.crearUnaNuevaPersona("gdfgdf","gdfgdfg",0,0d).getId());
			System.out.println(ps.buscarPersonaPorId(3).getDireccion());
			System.exit(1);
		} catch (ServiceException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	public static void main(String[] arg) {
		new Main();
	}
}
