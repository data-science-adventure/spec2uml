package com.github.danimaniarqsoft.service.mapper;

import com.github.danimaniarqsoft.domain.User;
import com.github.danimaniarqsoft.domain.UserRef;
import com.github.danimaniarqsoft.service.dto.UserDTO;
import com.github.danimaniarqsoft.service.dto.UserRefDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link UserRef} and its DTO {@link UserRefDTO}.
 * Also supports mapping full User or UserDTO instances to lightweight references.
 */
@Mapper(componentModel = "spring")
public interface UserRefMapper extends EntityMapper<UserRefDTO, UserRef> {
    /**
     * Map full User entity to UserRefDTO.
     */
    UserRefDTO userToUserRefDTO(User user);

    /**
     * Map full UserDTO to UserRefDTO.
     */
    UserRefDTO userDTOToUserRefDTO(UserDTO userDTO);

    /**
     * Map full User entity to lightweight UserRef domain object.
     */
    UserRef userToUserRef(User user);
}
