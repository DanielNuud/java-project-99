package hexlet.code.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class TaskStatusCreateDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String slug;

}
