package Exact_Match_Prototype;

import java.io.IOException;
import java.util.LinkedList;
import Exact_Match_Prototype.Nested_LL.MyNode;

public class QuestionInput {
	public static void main(String[] args) throws IOException{
		if (args.length < 2)
        {
			System.out.println("Please check input arguments, make sure arg[0] Question ID arg[>=1] answers");
        }
		String Question_ID = args[0];
		String Question_Type = null;
		try{
			Question_Type = Question_ID.substring(0,Question_ID.indexOf('.'));
		}
		catch(Exception e)
		{
			System.out.println("Please check Question ID format");
			
		}
		MyNode Main_Depo = LocalDataBaseSetup.Initialization();
        int Exact_Result = 0;
        int Question_length;
        LinkedList passing_list = null;
        int arg_index = 1;
        String Answer;
        while(true){
        if ((arg_index >= args.length) || (Exact_Result != 0))
        {
           break;
        }
        Answer = args[arg_index];
        // Simple Normalization
        Answer = Answer.replace('\\', ' ').toLowerCase().replaceAll("[^0-9a-zA-Z]", "");
        Question_length = Question_Analysis.getAlength(Answer);
        try
        {
        passing_list = LocalDataBaseSetup.GetPassingList(Main_Depo, Question_Type, Question_length);
        }
        catch(Exception e)
        {
        	System.out.println("No Question ID matched, please try another Question ID");
        	arg_index += 1;
        	continue;
        }
        Exact_Result = ExactMatch.ExactMatching(Question_ID,  Answer, passing_list);
        arg_index += 1;
        } 
        if (Exact_Result != 0)
        {
        	System.out.println("True");
        }
        else
        {
        	System.out.println("False");
        }
	}
}
