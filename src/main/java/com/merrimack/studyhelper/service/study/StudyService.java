package com.merrimack.studyhelper.service.study;

import com.merrimack.studyhelper.domain.enumclass.DisplayStatus;
import com.merrimack.studyhelper.domain.study.Study;
import com.merrimack.studyhelper.domain.study.StudyRepository;
import com.merrimack.studyhelper.domain.user.User;
import com.merrimack.studyhelper.domain.user.request.StudyRequest;
import com.merrimack.studyhelper.domain.user.request.UserRequest;
import com.merrimack.studyhelper.service.user.UserService;
import com.merrimack.studyhelper.support.ApiException;
import com.merrimack.studyhelper.support.ApiStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
@Transactional
public class StudyService {

    @Autowired
    StudyRepository studyRepository;

    @Autowired
    UserService userService;

    public Study find(Long id) {
        return studyRepository.findById(id).orElseThrow(() -> new ApiException(ApiStatus.USER_ID_NOT_EXIST));
    }

    public void createStudy(StudyRequest studyRequest) {
        studyRequest.validate();

        Study study = Study.builder()
                .title(studyRequest.getTitle())
                .content(studyRequest.getContent())
                .max(studyRequest.getMax())
                .displayStatus(DisplayStatus.OPEN)
                .build();

        studyRepository.save(study);

    }

    public void removeStudy(StudyRequest studyRequest) {
        Study study = find(studyRequest.getStudyId());
        study.setDisplayStatus(DisplayStatus.DELETE);
        studyRepository.save(study);

    }

    public void joinStudy(UserRequest userRequest) {
        userRequest.validate();
        Study study = find(userRequest.getStudyId());
        User user = userService.find(userRequest.getId());
        user.addStudy(study);

    }

    public List<Study> findAll() {
        return studyRepository.findAll();
    }
}
