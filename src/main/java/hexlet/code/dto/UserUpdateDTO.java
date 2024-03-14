package hexlet.code.dto;

import jakarta.validation.constraints.NotBlank;
import org.openapitools.jackson.nullable.JsonNullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {

    private JsonNullable<String> firstName;

    private JsonNullable<String> lastName;

    @NotBlank
    @Email
    private JsonNullable<String> email;

    @NotNull
    @Size(min = 3)
    private JsonNullable<String> password;
}
