
public class Pallindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str="aarati";
		String rev="";
		
		for(int i=str.length()-1 ; i>=0 ; i--)
   {
	
			rev=rev+str.charAt(i);
			
			
    }
		if(str.equals(rev))
		{
			System.out.println("it is palindrome");
		}
		else {
			System.out.println("it is not palindrome");
		}
		System.out.println(rev);
	}

}
