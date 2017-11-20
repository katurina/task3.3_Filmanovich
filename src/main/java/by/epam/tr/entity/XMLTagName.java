package by.epam.tr.entity;

public enum XMLTagName {
    PEOPLE, PERSON, NAME, SURNAME, TELEPHONE, EMAIL;

    private static final String PEOPLE_STRING = "people";
    private static final String PERSON_STRING = "person";
    private static final String NAME_STRING = "name";
    private static final String SURNAME_STRING = "surname";
    private static final String TELEPHONE_STRING = "telephone";
    private static final String EMAIL_STRING = "email";

    public static XMLTagName getXMLTagName(String element) {
        switch (element) {
            case PEOPLE_STRING:
                return PEOPLE;
            case PERSON_STRING:
                return PERSON;
            case NAME_STRING:
                return NAME;
            case SURNAME_STRING:
                return SURNAME;
            case TELEPHONE_STRING:
                return TELEPHONE;
            case EMAIL_STRING:
                return EMAIL;
            default:
                throw new EnumConstantNotPresentException(XMLTagName.class, element);
        }
    }
}

