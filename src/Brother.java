import java.util.ArrayList;
import java.util.Arrays;

public class Brother extends Person {
	private Pledge little;
	private int familySize;
	
	public Brother(String s){
		String arr[] = s.split(":");
		super.setName(arr[0]);
		ArrayList<String> pledges = new ArrayList<String>(Arrays.asList(arr[1].split(",")));
		
		this.setPl(new PreferenceList(pledges));
		this.little = null;
		this.familySize = (int) Math.floor(Math.random()*5);
	}
	
	public void setLittle(Pledge p){
		this.little = p;
	}
	public Pledge getLittle(){
		return little;
	}
	public boolean equals(Object o){
		if (o == null){
			return false;
		} else{
			Brother casted = (Brother)o;
			if (casted.getName().equals(this.getName())){
				return true;
			} else {
				return false;
			}
		}
	}
	public String getName(){
		return super.getName();
	}
	public PreferenceList getPl(){
		return super.getPl();
	}
	
	public boolean hasLittle(){
		return (this.little != null);
	}
	public boolean inList(Pledge p){
		return super.getPl().inList(p);
	}
	
	public boolean propose(Pledge p){
		if (this.getName().equals("Gary McKee") && p.getName().equals("Brian Mulligan")){
			//System.out.println("GIRUGAMESH");
		}
		if (p.getBig() != null) {
			//System.out.println(this.getName()+ " here!");
			if (!p.getPl().inList(this)){
				//System.out.println("SABER!!!");
				return false;
			} else {
				if (p.prefers(this)){
					p.setBig(this);
					this.little = p;
					return true;
				} else{
					return false;
				}
			}
		} else {
			//System.out.println(this.getName()+" when i should be here");
			p.setBig(this);
			this.little = p;
			return true;
		}
	}
	public String toString(){
		return ""+this.getName() +": " + this.getPl().toString();
	}
	
}
