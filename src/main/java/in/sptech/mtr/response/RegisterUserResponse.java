package in.sptech.mtr.response;

public class RegisterUserResponse {


    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Long phoneNumber;
    private String password;
    private Integer role;
    private Integer yearOfExp;

    public RegisterUserResponse(Long id, String firstName, String middleName, String lastName, Long phoneNumber, String password, Integer role, Integer yearOfExp) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.yearOfExp = yearOfExp;
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public Integer getRole() {
        return role;
    }

    public Integer getYearOfExp() {
        return yearOfExp;
    }
}
