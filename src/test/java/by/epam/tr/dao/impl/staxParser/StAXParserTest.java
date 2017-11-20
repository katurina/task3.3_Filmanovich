package by.epam.tr.dao.impl.staxParser;

import by.epam.tr.dao.Parser;
import by.epam.tr.entity.Page;
import by.epam.tr.entity.Person;
import org.junit.Test;

public class StAXParserTest {
    @Test
    public void parse() throws Exception {
        Parser parser = new StAXParser();
        parser.setCurrentPage(1);
        Page<Person> parse = parser.parseXML();
        System.out.println(parse.getEntity());
    }


}
