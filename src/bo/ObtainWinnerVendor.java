package bo;

import java.util.Iterator;
import java.util.ListIterator;

import entities.Vendedora;
import entities.Vendedoras;

public class ObtainWinnerVendor {
	static public int ObtainWinner(Vendedoras vendors)
	{
		Iterator<Vendedora> vendedoras=vendors.vendedoras.iterator();
		Vendedora vendor;
		ListIterator<Integer> ventas;
		int maxAdjacent;
		int maxVendor=0;
		while(vendedoras.hasNext())
		{
			vendor=vendedoras.next();
			ventas =vendor.ventas.listIterator();
			while(ventas.hasNext())
			{
				ventas.next();
				maxAdjacent=vendors.ConditionVentasConcecutivas;
				int localMax=0;
				ListIterator<Integer> subVentas= vendor.ventas.listIterator(ventas.previousIndex());
				while(subVentas.hasNext() && maxAdjacent>0)
				{
					Integer number = subVentas.next();
					localMax+=number.intValue();
					maxAdjacent--;
				}
				if(vendor.max<localMax)
					vendor.max=localMax;
				
			}
		}
		for(int i=0;i<vendors.vendedoras.size();i++) {
			vendedoras=vendors.vendedoras.iterator();
		while(vendedoras.hasNext())
		{
			vendor=vendedoras.next();
			if(vendor.max>=maxVendor)
			{
				maxVendor=vendor.max;
			}else vendedoras.remove();
		}}
		if(vendors.vendedoras.size()>1) {
			vendors.ConditionVentasConcecutivas++;
			ObtainWinner(vendors);
		}
		return 0;
		
	}
}
