package org.backend.onlybeautydemo.models.dto;


public class AdminProfileDTO {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userName;
    private String password;

    public AdminProfileDTO(String password, String userName, String emailAddress, String lastName, String firstName) {
        this.password = password;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
