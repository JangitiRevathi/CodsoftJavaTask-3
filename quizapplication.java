import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class quizapplication{
    private static final String[]questions={
        "what is the capital of france?",
        "which planet is known as the red planet?",
        "who wrote  romeo and juliet?"
    };
    private static String[]options={
        "A)London  B)Paris  C)Rome",
        "A)Venus  B)Mars  C)Jupiter",
        "A)Charles Dickens  B)William Shakespeare  C)Jane Austen"
    };
    private static final String[] answers={"B","B","B"};
    private static int score=0;
    private static int currentquestion=0;
    public static void main(String[]args){
        Timer timer=new Timer();
        TimerTask task;
        task = new TimerTask(){
            @Override
            public void run(){
                System.out.println("time is up!");
                displaynextquestion();
            }
        };
        timer.schedule(task,10000);
        displaynextquestion();
    }
    private static void displaynextquestion(){
        if(currentquestion<questions.length){
            System.out.println(questions[currentquestion]);
            System.out.println(options[currentquestion]);
            Scanner scanner=new Scanner(System.in);
            String useranswer=scanner.next().toUpperCase();
            if(useranswer.equals(answers[currentquestion])){
                System.out.println("correct!");
                score++;
            }else{
                System.out.println("incorrect!");
            }
            currentquestion++;
            displaynextquestion();
        }else{
            System.out.println("quiz ended.your score:"+ score + "/" + questions.length);
        }
    }
}
    