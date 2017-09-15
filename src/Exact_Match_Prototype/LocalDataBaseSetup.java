package Exact_Match_Prototype;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import Exact_Match_Prototype.Nested_LL.MyNode;
import Exact_Match_Prototype.Nested_LL.MyQType;
public class LocalDataBaseSetup {
	// Initialize the local database, reading from txt file
	public static MyNode Initialization() throws IOException{
		MyNode Main_Depo = new MyNode();
		String line2;
        BufferedReader in2;
        int line_num2 = 0;
        in2 = new BufferedReader(new InputStreamReader(LocalDataBaseSetup.class.getResourceAsStream("/Perfect_Depository.txt")));
        //in2 = new BufferedReader(new FileReader("resources/Perfect_Depository.txt"));
        line2 = in2.readLine();
        /* Initialize data collectors*/
        String txt_Answer = null;
        String Q_id = null;
        String Question_Type;
        int A_count = 0;
        while(line2 != null)
       {
         // Classify the type of input data
       	 String data = line2;
       	 if (line_num2 % 3 == 0)
       	 {
       		txt_Answer = data;
       	 }
       	 else if (line_num2 % 3 == 1)
       	 {
       		A_count = Integer.parseInt(data);
       	 }
       	 else 
       	 {
       		Q_id = data;
       		Question_Type = Q_id.substring(0,Q_id.indexOf('.'));
       		Main_Depo.add(txt_Answer,Question_Type,A_count,Q_id);
       	 } 
       	line_num2 ++;
        line2 = in2.readLine();
       }
       in2.close();
       return Main_Depo;
	}
	// After obtaining the user-inputed question, return the list of possible answers from the local database
	public static LinkedList<?> GetPassingList(MyNode depo, String Question_Type, int Answer_Length){
		LinkedList<?> temp = new LinkedList<Object>();
		MyQType temp_QA  = null;
		MyNode temp_depo = depo;
		while (temp_depo.next != null)
    	{
    		if (temp_depo.get_Question_type().equals(Question_Type))
    		{
    			temp_QA = temp_depo.get_ll();
    			break;
    		}
    		temp_depo = temp_depo.next;
    	}

		while (temp_QA != null)
    	{
    		if (temp_QA.get_answer_count() == Answer_Length)
    		{
    			temp = temp_QA.get_QA();
    			break;
    		}
    		temp_QA = temp_QA.next;
    	}
		return temp;
	}
}
