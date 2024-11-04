import java.util.ArrayList;

public class Logik {
    private int letterCount_ = 0;
    private int wordCount_ = 0;
    private String longestWord_ = "";
    private ArrayList<String> userInput_ = new ArrayList<>();

    public Logik(){
    }

    public Logik(String[] strings) //Konstruktör gjord för testfall utan användar input används inte utanför test
    {
        for(String s: strings)
        {
            addLine(s);
        }
    }

    public void calculateResult()
    {
        if(isListempty())
            return;

        for (String s : userInput_) {

            String[] tmp = s.split(" ");
            wordCount_ += tmp.length;
            for (String s2: tmp)
            {
                setLongestWord_(s2);
                letterCount_ += s2.length();
            }
        }
    }

    private boolean isListempty()
    {
        if(userInput_.isEmpty()) //se till att det finns en "Stop att ta bort innan den försöker"
            return true;

        userInput_.removeLast(); //Ta bort stringen med stop då den inte ska med till logiken

        return userInput_.isEmpty(); //kolla igen så att det finns någon logik att gå igenom
    }

    public boolean isUserFinished(String input, String endCommand)
    {
        return input.equalsIgnoreCase(endCommand);
    }

    public void addLine(String s)
    {
        userInput_.add(s);
    }

    public int getLineAmount()
    {
        return userInput_.size();
    }

    public int getLetterCount_()
    {
        return letterCount_;
    }

    public int getWordCount_()
    {
        return wordCount_;
    }

    private  void setLongestWord_(String s)
    {
        if(s.length() > longestWord_.length())
            longestWord_ = s;
    }

    public String getLongestWord_()
    {
        return longestWord_;
    }
}
