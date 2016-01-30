package net.furikuri.domain;

public class Account {
    private final String email;
    private final String name;
    private final String firstName;

    public Account(
            final String email,
            final String name,
            final String firstName) {
        this.email = email;
        this.name = name;
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }
}
