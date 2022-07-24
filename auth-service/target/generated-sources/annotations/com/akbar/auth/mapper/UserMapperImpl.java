package com.akbar.auth.mapper;

import com.akbar.auth.dto.UserDto;
import com.akbar.auth.dto.UserDto.UserDtoBuilder;
import com.akbar.auth.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-25T01:09:21+0700",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user, String token) {
        if ( user == null && token == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        if ( user != null ) {
            if ( user.getId() != null ) {
                userDto.id( user.getId() );
            }
            userDto.login( user.getLogin() );
        }
        if ( token != null ) {
            userDto.token( token );
        }

        return userDto.build();
    }
}
