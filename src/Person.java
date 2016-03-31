

public class Person {

	private PreferenceList pl;
	private String name;
	
	public Person(){
		this.pl = null;
		this.name = null;
	}
	public Person(String s){
		this.name = s;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PreferenceList getPl() {
		return pl;
	}
	public void setPl(PreferenceList pl) {
		this.pl = pl;
	}
	
	public String toString(){
		return this.name;
	}
	
	
}
