package exercise.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// BEGIN
@Getter
@Setter
public class GuestCreateDTO {

    @NotBlank
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^\\+\\d{11,13}$")
    public String phoneNumber;

    @Pattern(regexp = "^\\d{4}$")
    private String clubCard;

    @Future
    private LocalDate cardValidUntil;

}
// END
