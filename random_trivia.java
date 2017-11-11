import java.util.Scanner;
public class random_trivia
{
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		
		String [] questions = new String[5];
		String [] choices = new String[5];
		String [] correctAnswer = new String[5];
		Boolean [] asked = new Boolean[5];
		
		questions[0] = "Who created Final Fantasy?";
		choices[0] = "A. Yugi Naka\nB. Hironobu Sakaguchi\nC. Nobou Uematsu";
		correctAnswer[0] = "b";
		asked[0] = false;
		
		questions[1] = "What mode allowed for scaling and rotation of sprites on the Super Nintendo?";
		choices[1] = "A. mode 7\nB. Mode FX \nC. Mode 4";
		correctAnswer[1] = "a";
		asked[1] = false;
		
		questions[2] = "What name did Sega go by when the company was first started?";
		choices[2] = "A. Segatto\nB. Senshi Games\nC. Seattle Games";
		correctAnswer[2] = "c";
		asked[2] = false;
		
		questions[3] = "What is 5 * 5?";
		choices[3] = "A. 24\nB. 25\nC. 100";
		correctAnswer[3] = "b";
		asked[3] = false;
		
		questions[4] = "The answer is 0";
		choices[4] = "A. 0\nB. 123\nC. 6";
		correctAnswer[4] = "a";
		asked[4] = false;
		
		int r = 0;
		String input = "";
		
		int score = 0;
		
		for(int i = 0; i < 5; i++)
		{
			
			r = (int)(Math.random()*4);
			
			while(asked[r])
			{
				r = (int)(Math.random()*5);
			}
			
			System.out.println(questions[r]);
			System.out.println(choices[r]);
			System.out.print("\nSelect an answer: ");
			input = s.nextLine().toUpperCase();
			
			while(input.charAt(0) != 'A' && input.charAt(0) != 'B' && input.charAt(0) != 'C')
			{
				System.out.print("That is not an option\n\nSelect an answer: ");
				input = s.nextLine().toUpperCase();
			}
			
			if(input.charAt(0) == correctAnswer[r].toUpperCase().charAt(0))
			{
				System.out.println("\nCorrect\n");
				score++;
			}
			else
			{
				System.out.println("\nWrong\n");
			}
			
			asked[r] = true;
		}
		
		System.out.println("\nYour final score is " + score);
	}
}
