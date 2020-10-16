/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author joset
 */
public class AccesoFichero {

    private static String ruta="C:\\Jose\\contactos.csv";
    private static  String separador=",";
    public static void grabarContacto(Contacto c) {
        try {
            FileWriter fw=new FileWriter(ruta, true);
            String linea=c.getNombre()+separador+c.getApellido()+separador+c.getTelefono()+"\n";
            fw.write(linea);
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static ArrayList<Contacto> recuperarContactos() {
		ArrayList<Contacto> lista_contactos=new ArrayList<Contacto>();
		try {
			FileReader fr=new FileReader(ruta);
			BufferedReader br=new BufferedReader(fr);
			String linea=br.readLine();
			while(linea!=null)
			{
				String[] datos=linea.split(separador);
				String nombre=datos[0];
				String apellido=datos[1];
				String telefono=datos[2];
				Contacto c=new Contacto(nombre, apellido, telefono);
				lista_contactos.add(c);
				linea=br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_contactos;
    }
    
    public static ArrayList<Contacto> buscarPorNombre(ArrayList<Contacto> lista_contactos, String nombre_buscado) {
		ArrayList<Contacto> lista_buscados=new ArrayList<Contacto>();
                String regex="[A-Z]*"+nombre_buscado.toUpperCase()+"[A-Z]*";
		for (Contacto contacto : lista_contactos) {
			if (contacto.getNombre().toUpperCase().matches(regex))
			{
				lista_buscados.add(contacto);
			}
		}
		return lista_buscados;
	}
    
}
