package net.furikuri.clients;

public class Account {
    private String email;
    private String name;
    private String firstName;

    public Account() {
    }

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
