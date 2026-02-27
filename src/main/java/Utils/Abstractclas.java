package Utils;

import java.util.ArrayList;
import java.util.List;

public class Abstractclas {
	
	public static List<String> selectedNames = new ArrayList<>();
	public static void addName(String name) {
        selectedNames.add(name);
    }

    public static List<String> getNameList() {
        return selectedNames;
    }
    
    public static void clearList() {
        selectedNames.clear();
    }

}
