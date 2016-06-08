import java.util.*;


public class Graph {

	ArrayList<Vertex> listeSommet;
	ArrayList<Edge> listePref;
	ArrayList<Edge> listeInter;
	

	public Graph(){
		this.listePref = null;
		this.listeInter = null;
	}

	public ArrayList<Vertex> getListeSommet(){
		return this.listeSommet;
	}

	public ArrayList<Edge> getListePref(){
		return this.listePref;
	}

	public ArrayList<Edge> getListeInter(){
		return this.listeInter;
	}
	
	public void addPref(Edge e1) {
		this.listePref.add(e1);
	}
	
	public void addInter(Edge e1) {
		this.listeInter.add(e1);
	}
	
	public boolean isIn(Vertex v1){
		if (listeSommet.contains(v1)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public void coloring(int k){
		int i = 1;
		Vertex v1 = new Vertex();
		while(listeSommet.isEmpty()!= true) {
			if(trivialVertex()) { // si il y a un sommet trivialement coloriable
				v1 = getTrivialVertex();
				int color = findColor(v1, k); // regarde les couleur dispo en fonction des voisins
				v1.setColor(color);
			}
			else{
				spilling();
			}
		}
	}
}
