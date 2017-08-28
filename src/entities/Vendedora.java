package entities;

import java.util.ArrayList;
import java.util.List;

public class Vendedora {
	public List<Integer> ventas;
	public int max;
	public int id;
	public Vendedora() {
		super();
		ventas = new ArrayList<>();
		max=0;
	}
}
