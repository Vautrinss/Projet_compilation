public class Vertex {

	String name;
	int color;
	boolean existing;

	public Vertex(String n){
		this.name= n;
		this.color = -1;
		this.existing = false;
	}

	public String getName() { 
		return this.name;
	}
	public int getColor() { 
		return this.color;
	}
	public boolean getExisting() {
		return this.existing;
	}
	
	public void setName(String n){
		this.name = n;
	}

	public void setColor(int c){
		this.color = c;
	}
	public void setExisting(boolean b) {
		this.existing = b;
	}
}
