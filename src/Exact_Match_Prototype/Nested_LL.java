package Exact_Match_Prototype;

import java.util.LinkedList;

public class Nested_LL {
	// Data type to put in the nested linked list
	public static class QA_deposit{
		private String Question_ID;
		private String txt_Answer;
		public QA_deposit(String a, String b)
		{
			this.Question_ID = b;
			this.txt_Answer = a;
		}
		public String get_Answer(){
			return this.txt_Answer;
		}
		public String get_Qustion_ID(){
			return this.Question_ID;
		}
	}
	// Nested Linked List
	public static class MyQType {
        private int answer_count;
        private LinkedList<QA_deposit> QA_deposit;
        public MyQType next;
        public MyQType (){
        	this.answer_count = 0;
            this.QA_deposit = new LinkedList<QA_deposit>();
            this.next = null;
        }
        protected void add(String txt_Question, int A_count, String Question_ID) {
        	MyQType temp = this;
        	if (this.get_answer_count() == 0)
        	{
        		this.answer_count = A_count;
        		this.QA_deposit = new LinkedList<QA_deposit>();
        		QA_deposit temp_QA = new QA_deposit(txt_Question, Question_ID);
	            temp.get_QA().add(temp_QA);
	            this.next = new MyQType();
	            return;
        	}
        	else if (temp.get_answer_count() == A_count)
        	{
        		QA_deposit temp_QA = new QA_deposit(txt_Question,Question_ID);
    			temp.get_QA().add(temp_QA);
        	}
        	else
        	{
        		temp.next.add(txt_Question,A_count, Question_ID);
        	}
        }
        public int get_answer_count(){
        	return this.answer_count;
        }
        public LinkedList<QA_deposit> get_QA(){
        	return this.QA_deposit;
        }
    }
	// First Linked List
	public static class MyNode {
        private String Q_Type;
        private MyQType ll_deposit;
        public MyNode next;
        public MyNode (){
        	this.Q_Type = null;
            this.ll_deposit = new MyQType();
            this.next = null;
        }
        public void add(String txt_Answer, String Question_Type, int A_count, String Question_ID) {
    		MyNode temp = this;
        	if (this.get_Question_type() == null)
        	{
        		this.Q_Type = Question_Type;
        		this.ll_deposit = new MyQType();
	            this.get_ll().add(txt_Answer,A_count,Question_ID);
	            this.next = new MyNode();
	            return;
        	}
        	else if(temp.get_Question_type().equals(Question_Type))
        	{
        		temp.get_ll().add(txt_Answer,A_count,Question_ID);
        	}
        	else
        	{
        		temp.next.add(txt_Answer,Question_Type,A_count, Question_ID);
        	}
        }
        public String get_Question_type(){
        	return this.Q_Type;
        }
        public MyQType get_ll(){
        	return this.ll_deposit;
        }
    }
}

