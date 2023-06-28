package com.application.firststep.services;

import com.application.firststep.DTOs.*;
import com.application.firststep.model.User;

public interface AccountService {

	User saveUser(UserDto userDto);
	User changePassword(PasswordChangeDto passwordChangeDto);
	User loginUser(UserDto userDto);

}
