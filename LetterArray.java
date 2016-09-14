
public class LetterArray {
	
	public String[] getArray(int size){
		String[] letArray = new String[size];
		for(int i=65; i<65+size; i++){
			 letArray[i-65] = Character.toString((char) (i));
		}
		return letArray;
	}
}
