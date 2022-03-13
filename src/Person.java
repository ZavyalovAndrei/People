import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        return getAddress().isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        if (!hasAddress()) {
            return "Адрес неизвестен.";
        } else {
            return address;
        }
    }

    public void setAddress(String address) {
        new PersonBuilder().setAddress(address);
    }

    public void setAge(int age) {
        new PersonBuilder()
                .setAge(age);
    }

    public int happyBirthday() {
        return age++;

    }

    public PersonBuilder newChildBuilder(String momSurname, String momAddress) {
        return new PersonBuilder()
               .setSurname(momSurname)
               .setAddress(momAddress);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(name);
        if (surname != null) {
            sb.append(" ").append(surname);
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return hashCode();
    }
}