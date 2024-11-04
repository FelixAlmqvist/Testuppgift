import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCases {

    String[] strings = {"Testar", "result", "Encyklopedia ordet till vänster ska vara det längsta","dubbelkolla att den inte räknar med mellanrum", "stop"};
    Logik tmp = new Logik(strings);

    @Test
    public void LogikTestIfUserFinished(){

        for (int i = 0; i<strings.length-2; i++) { //Går igenom allt förutom sista strängen

            Assertions.assertFalse(tmp.isUserFinished(strings[i], "stop"));
        }
        //Dubbelkollar att sista strängen ska ha stängt av inmatningen
        Assertions.assertTrue(tmp.isUserFinished(strings[strings.length - 1], "stop"));

    }

    @Test
    public void LogikTestIfUserOnlyWroteStop()
    {
        String[] string = {"stop"};
        Logik tmp2 = new Logik(string);
        tmp2.calculateResult();
        Assertions.assertEquals(0,tmp2.getLineAmount()); //se till att den hamnar korrekt i Listener.displayResult när den körs i main
    }

    @Test
    public void LogikTestWordAmount(){
        tmp.calculateResult();
        Assertions.assertEquals(17,tmp.getWordCount_());
    }

    @Test
    public void LogikTestLetterAmount(){
        tmp.calculateResult();
        Assertions.assertEquals(96,tmp.getLetterCount_());
    }

    @Test
    public void LogikTestLongestWord()
    {
        tmp.calculateResult();
        Assertions.assertEquals("Encyklopedia",tmp.getLongestWord_());
    }
//test

}
