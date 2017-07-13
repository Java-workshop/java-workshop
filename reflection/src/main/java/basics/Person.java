package basics;

import annotations.LogInvocation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Person implements Serializable{
    public boolean isMale;
    private String name;
    private String[] nickNames;
    private int age;

    public String[] getNickNames() {
        return this.nickNames;
    }

    public void setNickNames(final String[] nickNames) {
        this.nickNames = nickNames;
    }

    public Person() {
    }
    public Person(final String name, final int age, final boolean isMale, String... nickNames) {
        this.name = name;
        this.isMale = isMale;
        this.age = age;
        this.nickNames = nickNames;

    }

    public Person(final String name, final int age, ArrayList<String> nickNames) {
        this.name = name;
        this.age = age;

        this.nickNames = nickNames == null ? null :(String[])nickNames.toArray();
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    @LogInvocation(LogInvocation.LogLevel.DEBUG)
    private void checkAge() {
        if (age < 0) {
            throw new RuntimeException("Age cannot be negative");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", nickNames=").append(Arrays.toString(nickNames));
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
