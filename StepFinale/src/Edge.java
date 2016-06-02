public class Edge {

	Vertex sommet1;
	Vertex sommet2;
	boolean type;

	public Edge(Vertex s1, Vertex s2, boolean t){
		this.sommet1= s1;
		this.sommet2= s2;
		this.type = t;
	}

	public Vertex getSommet1() { 
		return this.sommet1;
	}

	public Vertex getSommet2() { 
		return this.sommet2;
	}
	
	public boolean getType() {
		return this.type;
	}
	
	public void setSommet1(Vertex s1){
		this.sommet1 = s1;
	}
	
	public void setSommet2(Vertex s2){
		this.sommet2 = s2;
	}
}
