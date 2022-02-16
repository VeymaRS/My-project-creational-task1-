import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge (int age) throws IllegalArgumentException  {
if (age > 0) {
    this.age = age;
    return this;
} else {
    throw new IllegalArgumentException("The age value incorrect!");
}
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException  {
        OptionalInt optionalInt = OptionalInt.of(age);
        Person person = new Person(name, surname, optionalInt, address);
        if (person.checkBuilding()) {
            return person;
        } else {
            throw new IllegalStateException("Person can`t work because arguments incorrect");
        }
    }
}
