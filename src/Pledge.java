import java.util.ArrayList;
import java.util.Arrays;

public class Pledge extends Person {
	private Brother big;
	
	public Pledge(String s){
		String arr[] = s.split(":");
		super.setName(arr[0]);
		ArrayList<String> brothers = new ArrayList<String>(Arrays.asList(arr[1].split(",")));
		
		this.setPl(new PreferenceList(brothers));
		this.big = null;
	}
	
	public String getName(){
		return super.getName();
	}
	
	public Brother getBig(){
		return big;
	}
	public void setBig(Brother b){
		if (this.big != null){
			this.big.setLittle(null);
		}
		this.big = b;
	}
	
	public boolean prefers(Brother b){
		
		int p1 = this.getPl().indexInList(b);
		int p2 = this.getPl().indexInList(this.big);
		//System.out.println(this.getName());
		if (this.getName().equals("Brian Mulligan")){
			//System.out.println("p1: " + b.getName()+" p2: "+this.big.getName());
		}
		if (p1 == -1){
			System.out.println("Sorry!");
			return false;
		} else if (p2 == -1){
			return true; 
		} else if (p1 > p2){
			return false;
		} else {
			return true;
		}
	}
	public String toString(){
		return ""+this.getName() + ": "+this.getPl().toString();
	}
	
}
