package com.application.firststep.services;

import com.application.firststep.DTOs.*;
import com.application.firststep.model.User;

public interface AccountService {

	User saveUser(UserDto userDto);
	User changePassword(UserDto userDto);
	User loginUser(UserDto userDto);

}
