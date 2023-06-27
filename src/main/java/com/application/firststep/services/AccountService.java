package com.application.firststep.services;

import com.application.firststep.DTOs.UserDto;
import com.application.firststep.model.User;

public interface AccountService {

	User saveUser(UserDto userDto);

}
