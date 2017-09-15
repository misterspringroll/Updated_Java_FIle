package Exact_Match_Prototype;

public class Question_Analysis {
	public static int getAlength(String inputA){
		String[] Question_splited = inputA.trim().split("\\s+"); 
        int Question_length = Question_splited.length;
        return Question_length;
	}
}
