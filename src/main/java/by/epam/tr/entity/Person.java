package by.epam.tr.entity;

public class Person {
    private int id;
    private String name;
    private String surname;
    private String telephone;
    private String email;

    public Person() {
    }

    public Person(int id, String name, String surname, String telephone, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        if (getId() != person.getId()) {
            return false;
        }
        if (getName() != null ? !getName().equals(person.getName()) : person.getName() != null) {
            return false;
        }
        if (getSurname() != null ? !getSurname().equals(person.getSurname()) : person.getSurname() != null) {
            return false;
        }
        if (getTelephone() != null ? !getTelephone().equals(person.getTelephone()) : person.getTelephone() != null) {
            return false;
        }
        return getEmail() != null ? getEmail().equals(person.getEmail()) : person.getEmail() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getTelephone() != null ? getTelephone().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}