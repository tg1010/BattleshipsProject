
public class NumberArray {
	
	public String[] getArray(int size){
		String[] numArray = new String[size];
		for(int i=0; i<size; i++){
			 numArray[i] = Integer.toString(i+1);
		}
		return numArray;
	}
}
