package Exact_Match_Prototype;

import java.util.LinkedList;

import Exact_Match_Prototype.Nested_LL.QA_deposit;

public class ExactMatch {
	public static int ExactMatching(String Q_ID, String Answer, LinkedList<?> passing_list)
	{
		int return_int = 0;
		QA_deposit temp;
		if (passing_list.size() != 0){
		for (int i = 0; i <= passing_list.size()-1; i++)
		{
			temp = (QA_deposit) passing_list.get(i);
			String temp_Answer = temp.get_Answer().replace('\\', ' ').toLowerCase().replaceAll("[^a-zA-Z ]", "").replaceAll("\\s+","");
			String temp_ID = temp.get_Qustion_ID();
			if (temp_ID.equals(Q_ID))
			{
			// Simple Normalization 
				Answer = Answer.replaceAll("10","ten");
				Answer = Answer.replaceAll("1","one");
				Answer = Answer.replaceAll("2","two");
			    Answer = Answer.replaceAll("3","three");
			    Answer = Answer.replaceAll("4","four");
			    Answer = Answer.replaceAll("5","five");
			    Answer = Answer.replaceAll("6","six");
			    Answer = Answer.replaceAll("7","seven");
			    Answer = Answer.replaceAll("8","eight");
			    Answer = Answer.replaceAll("9","nine");
			    Answer = Answer.replace('\\', ' ').toLowerCase().replaceAll("[^a-zA-Z ]", "").replaceAll("\\s+","");
			// If the questions are exactly matched to the data in the local database
				if (temp_Answer.toLowerCase().equals(Answer))
				{
					return_int = 1;
					break;
				}
			}
			else
			{
				continue;
			}
		}
		}
		return return_int;
	}
}
