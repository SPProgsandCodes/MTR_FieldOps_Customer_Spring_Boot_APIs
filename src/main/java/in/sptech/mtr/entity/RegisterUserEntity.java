package in.sptech.mtr.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.mapping.Any;

import java.time.Instant;
import java.util.List;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_users_email", columnNames = "email")
        }
)
public class RegisterUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "f_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String firstName;

    @Column(name = "m_name", nullable = true)
    @Size(min = 2, max = 100)
    private String middleName;

    @Column(name = "l_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String lastName;

    @Column(nullable = false, length = 150)
    @Email
    @NotBlank
    private String email;

    @Column(name = "phone", nullable = false, length = 50)
    @NotNull
    private Long phoneNumber;

    @Column(nullable = false, length = 60)
    private String passwordHash;

    @Column(nullable = false, length = 10)
    private Integer roleId;

    @Column(nullable = false, length = 10)
    private Integer yearOfExp;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    @Column(nullable = true, length = 200)
    private String profileUrl;

    @Column(nullable = true, length = 10)
    private Float rating;

    @Column(nullable = true, length = 60)
    private Integer totalMoneySpent;

    @Column(nullable = true, length = 10)
    private Integer servicesRequested;

    @Column(nullable = true, length = 10)
    private Integer totalServiceDelivered;

    @Column(nullable = true, length = 20)
    private String paymentMethod;

    @Column(nullable = true, length = 10)
    private Boolean isOnline;


    private Boolean isEnabled;



    private List<Any> reviews;






    // Getters and Setters

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public void setTotalMoneySpent(Integer totalMoneySpent) {
        this.totalMoneySpent = totalMoneySpent;
    }

    public Integer getServicesRequested() {
        return servicesRequested;
    }

    public void setServicesRequested(Integer servicesRequested) {
        this.servicesRequested = servicesRequested;
    }

    public Integer getTotalServiceDelivered() {
        return totalServiceDelivered;
    }

    public void setTotalServiceDelivered(Integer totalServiceDelivered) {
        this.totalServiceDelivered = totalServiceDelivered;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public List<Any> getReviews() {
        return reviews;
    }

    public void setReviews(List<Any> reviews) {
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }
}
