package com.merrimack.studyhelper.service.user;

import com.merrimack.studyhelper.domain.user.User;
import com.merrimack.studyhelper.domain.user.UserRepository;
import com.merrimack.studyhelper.support.ApiException;
import com.merrimack.studyhelper.support.ApiStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User find(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new ApiException(ApiStatus.USER_ID_NOT_EXIST));
        return user;
    }

}
