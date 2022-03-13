public class PersonBuilder implements Builder{
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) throws IllegalStateException {
        if (name.isEmpty()) {
            throw new IllegalStateException("Error.Name can`t be empty");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalStateException {
        if (surname.isEmpty()) {
            throw new IllegalStateException("Error.Surname can`t be empty");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalStateException {
        if (age < 0) {
            throw new IllegalStateException("Error. Invalid age.");
        } else if (this.build().hasAge()) {
            this.age = age;
        } else {
            this.age = build().happyBirthday();
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalStateException("Error.\"Name\" and \"Surname\" should`t be empty.");
        } else {
            person = new Person(name, surname, age, address);
        }
        return person;
    }
}