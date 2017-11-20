package by.epam.tr.dao.impl.domParser;


import by.epam.tr.dao.Parser;
import org.junit.Test;

public class MyDOMParserTest {
    @Test
    public void parse() throws Exception {
        Parser domParser = new MyDOMParser();
        domParser.setCurrentPage(1);
        System.out.println(domParser.parse().getEntity());
    }


}
