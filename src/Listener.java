import java.util.Scanner;

public class Listener {

    //inputs
    Scanner listener_ = new Scanner(System.in);
    private String line_ = "";


    //objekt för logik funktioner
    Logik myLogik = new Logik();


    public Listener(String endCommand){
        //Lägg till alla rader man vill skriva in i en arraylist
        System.out.println("Skriv några rader");
        System.out.println("Skriv stop när du känner dig färdig");
        while(!myLogik.isUserFinished(line_, endCommand))
        {
            line_ = listener_.nextLine();
            myLogik.addLine(line_);
        }

        myLogik.calculateResult(); //skicka input till Logik klassen

        displayResult(); //skicka resultat till terminal
    }

    private void displayResult()
    {
        if(myLogik.getLineAmount() == 0) //om man endast skrev stop kördes inte en majoritet av koden och istället skickas ett special meddelande
        {
            System.out.println("Du skrev endast stop så finns tyvärr inget resultat");
            return;
        }
        System.out.println("Du skrev: " + myLogik.getLineAmount() + " rader");
        System.out.println("Det innehöl: " + myLogik.getWordCount_() + " ord");
        System.out.println("och: " + myLogik.getLetterCount_() + " bokstäver");
        System.out.println("Det längsta ordet var: " + myLogik.getLongestWord_());
    }
}
