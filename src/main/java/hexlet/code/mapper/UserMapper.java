package hexlet.code.mapper;

import hexlet.code.dto.UserCreateDTO;
import hexlet.code.dto.UserDTO;
import hexlet.code.dto.UserUpdateDTO;
import hexlet.code.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(
        uses = { JsonNullableMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class UserMapper {
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @BeforeMapping
//    public void encryptPassword(UserCreateDTO data) {
//        var password = data.getPassword();
//        data.setPassword(passwordEncoder.encode(password));
//    }

    public abstract User map(UserCreateDTO dto);

    public abstract UserDTO map(User model);

    public abstract void update(UserUpdateDTO dto, @MappingTarget User model);
}
