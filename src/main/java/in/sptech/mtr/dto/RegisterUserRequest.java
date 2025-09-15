package in.sptech.mtr.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterUserRequest {

    @NotBlank
    @Size(min = 2, max = 100)
    private String firstName;

    @Size(min = 2, max = 100)
    private String middleName;

    @NotBlank
    @Size(min = 2, max = 100)
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private Long phoneNumber;

    @NotBlank
    @Size(min=8, max = 80)
    private String password;

    @NotNull
    private Integer roleId;

    @NotNull
    private Integer yearOfExp;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(Integer yearOfExp) {
        this.yearOfExp = yearOfExp;
    }
}
