package by.epam.tr.entity;

public enum XMLTagName {
    PEOPLE, PERSON, NAME, SURNAME, TELEPHONE, EMAIL;

    public static XMLTagName getXMLTagName(String element) {
        switch (element) {
            case "people":
                return PEOPLE;
            case "person":
                return PERSON;
            case "name":
                return NAME;
            case "surname":
                return SURNAME;
            case "telephone":
                return TELEPHONE;
            case "email":
                return EMAIL;
            default:
                throw new EnumConstantNotPresentException(XMLTagName.class, element);
        }
    }
}

