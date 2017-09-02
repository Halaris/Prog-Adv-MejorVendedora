package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import bo.ObtainWinnerVendor;
import entities.Vendedora;
import entities.Vendedoras;

public class Main {
/**
 * 	Adding a comment to test git
 * 	Seccond test
 * @param args
 */
	public static void main(String[] args) {
		// testing comment
		String file="in";
		Vendedoras Vendedoras = new Vendedoras();
		Vendedora vendor;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    line = br.readLine();
		    int cantVen= Integer.parseInt(line);
		    int cantProd;
		    int numVendor=1;//prueba de commits numero 2
		    while (cantVen>0 &&(line = br.readLine()) != null) {
		    	cantProd= Integer.parseInt(line);
		    	vendor= new Vendedora();
		    	 while (cantProd>0 &&(line = br.readLine()) != null) {
		    		 vendor.ventas.add(Integer.parseInt(line));
		    		 cantProd--;
		    	 }
		    	 cantVen--;
		    	 Vendedoras.vendedoras.add(vendor);
		    	 vendor.id=numVendor;
		    	 numVendor++;
		    }
		    line = br.readLine();
		    Vendedoras.ConditionVentasConcecutivas=Integer.parseInt(line);
		    ObtainWinnerVendor.ObtainWinner(Vendedoras);
		    System.out.println("termine!!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
