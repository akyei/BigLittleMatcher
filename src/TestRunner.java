import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestRunner {
	public static String stableMatch(ArrayList<Brother> brothers, ArrayList<Pledge> pledges) {
		StringBuffer buf = new StringBuffer();

		int numMatched = 0;
		HashMap<String, String> matched = new HashMap<String, String>();
		Set<Brother> unfinished = new HashSet<Brother>();
		
		Set<Brother> finished = new HashSet<Brother>();

		unfinished.addAll(brothers);
		//System.out.println(unfinished);
		int length = brothers.size();
		while ((finished.size() + numMatched) != length) {
			for (Brother b : unfinished) {
				if (b.getName().equals("Gary McKee")){
					//System.out.println("It's alright baby!");
				}
				if (b.hasLittle()){
					continue;
				}
				//System.out.println(b);
				if (b.getLittle() == null) {
					Person deqPerson = b.getPl().dequeue();
					Pledge tpil = null;
					for(Pledge p : pledges){
						
						if (deqPerson == null) break;
						if (deqPerson.getName().equals(p.getName())){
							tpil = p;
						}
					}
					//Pledge TPIL = (Pledge)tPIL;
					if (tpil == null) {
						finished.add(b);
						//unfinished.remove(b);
					} else {
						// If proposal is successful
						if (tpil.getBig() == null) {
							if (b.propose(tpil)) {
								numMatched++;
							} else {

							}
						} else {
							if (b.propose(tpil)) {
								
							} else {

							}
						}
					}
				}
			}

		}
		System.out.println(finished);
		HashSet<Pledge> unmatchedPledge = new HashSet<Pledge>();
		unmatchedPledge.addAll(pledges);
		for (Brother b : brothers) {
			String value = "";
			if (b.getLittle() == null) {
				value = "<No Match>";
			} else {
				value = b.getLittle().getName();
				unmatchedPledge.remove(b.getLittle());
			}
			matched.put(b.getName(), value);
			
		}
		
		System.out.println(unmatchedPledge);
		for(String k : matched.keySet()){
			
			buf.append(k+": "+matched.get(k)+"\n");
		}
		//To Implement, for any unmatched pledges, the brother with smallest family
		//gets matched
		
		return buf.toString();
	}

	public static void main(String args[]) {
		
		File f = new File("testFile");
		String line = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader(f));
			ArrayList<Brother> bros = new ArrayList<Brother>();
			ArrayList<Pledge> pledges = new ArrayList<Pledge>();
			do {
				try {
					line = in.readLine();
					if (line == null)
						continue;
					//System.out.println(line);
					String vals[] = line.split(":", 2);
					
					//String names[] = vals[1].split(",");
					if (vals[0].equals("B")){
						bros.add(new Brother(vals[1]));
					} else if (vals[0].equals("P")){

						pledges.add(new Pledge(vals[1]));
					}
				} catch (IOException e2) {
					System.err.println("IO Exception");
				}
			} while (line != null);
			in.close();
			
			
			System.out.println(stableMatch(bros, pledges));
			
			
		} catch (FileNotFoundException e1) {
			System.err.println("file not Found");
		} catch (IOException e2){
			System.err.println("I can't stop sh-shaking");
		}
		
	}
}
