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
		int i = k;
		Vertex v1;
		/*ArrayList<Edge> listePrefTemp = listePref;
		ArrayList<Edge> listeInterTemp = listeInter;
		Edge e;*/
		while(listeSommet.isEmpty()!= true) {
			v1 = getTrivialVertex(k);
			if(/*trivialVertex() &&*/v1.existing == true) { // si il y a un sommet trivialement coloriable et qu'il existe encore
				v1.existing = false;
				if(i>0){
					v1.color = findColor(v1, k); // regarde les couleur dispo en fonction des voisins
				}
				else {
					v1.color = 0; // 0=spill
				}

			}
			else{
				v1.color = 0;
			}
		}
		

	}
	
	@SuppressWarnings("null")
	public int findColor(Vertex v, int k) {
		ArrayList<Integer> listColor = null;
		ArrayList<Edge> listeInterTemp = listeInter;
		Edge e;
		
		while(k>0) {
			listColor.add(k);
			k--;
		}
		
		while(listeInterTemp.isEmpty() != true){
			e = listeInterTemp.get(1);
			if(e.sommet1 == v) {
				listColor.remove(e.sommet2.color);
			}
			else if(e.sommet2 == v){
				listColor.remove(e.sommet1.color);
			}
			listeInterTemp.remove(e);
		}
		return listColor.get(0);
	}
	
	public Vertex getTrivialVertex(int k){
		ArrayList<Vertex> ListeSommetTemp = listeSommet;
		Vertex v;
		Vertex v1 = null;
		for(int i = 0; i< ListeSommetTemp.size(); i++){
			v = ListeSommetTemp.get(i);
			if(getDegree(v)<k){
				v1 = v;
			}
			else{
				i++;
			}	
		}
		return v1;
	}
	
	public int getDegree(Vertex v){
		int j=0;
		ArrayList<Edge> listeInterTemp = listeInter;
		Edge e;
		
		while(listeInterTemp.isEmpty() != true){
			e = listeInterTemp.get(1);
			if(e.sommet1 == v) {
				j++;
			}
			else if(e.sommet2 == v){
				j++;
			}
			listeInterTemp.remove(e);
		}
		return j;
	} 
	
	/*public boolean TrivialVertex(){
		if
	}*/
	
	
}
