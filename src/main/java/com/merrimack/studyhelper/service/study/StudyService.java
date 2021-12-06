package com.merrimack.studyhelper.service.study;

import com.merrimack.studyhelper.domain.enumclass.DisplayStatus;
import com.merrimack.studyhelper.domain.enumclass.Time;
import com.merrimack.studyhelper.domain.study.Study;
import com.merrimack.studyhelper.domain.study.StudyRepository;
import com.merrimack.studyhelper.domain.user.User;
import com.merrimack.studyhelper.domain.user.request.ChangeStudyRequest;
import com.merrimack.studyhelper.domain.user.request.StudyRequest;
import com.merrimack.studyhelper.domain.user.request.UserRequest;
import com.merrimack.studyhelper.service.user.UserService;
import com.merrimack.studyhelper.support.ApiException;
import com.merrimack.studyhelper.support.ApiStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@Transactional
@Service
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

        List<Time> times = Arrays.stream(Time.values()).filter(x -> studyRequest.getTimeId().contains(x.getId())).collect(Collectors.toList());

        Study study = Study.builder()
                .title(studyRequest.getTitle())
                .content(studyRequest.getContent())
                .max(studyRequest.getMax())
                .displayStatus(DisplayStatus.OPEN)
                .times(times)
                .build();

        studyRepository.save(study);
    }


    public void changeTime(ChangeStudyRequest changeStudyRequest) {
        Study study = find(changeStudyRequest.getStudyId());
        List<Time> times = Arrays.stream(Time.values()).filter(x -> changeStudyRequest.getTimeIds().contains(x.getId())).collect(Collectors.toList());
        study.setTimes(times);

        studyRepository.save(study);
    }


    public void removeStudy(StudyRequest studyRequest) {
        Study study = find(studyRequest.getStudyId());
        study.setDisplayStatus(DisplayStatus.DELETE);

        studyRepository.save(study);

    }

    public void joinStudy(UserRequest userRequest) {
        Study study = find(userRequest.getStudyId());
        User user = userService.find(userRequest.getId());
        user.addStudy(study);
    }

    public List<Study> findAll() {
        return studyRepository.findAll();
    }

    public List<Study> findByTitleAndContent(String title, String content) {
        return studyRepository.findByTitleAndContent(title, content);
    }


}
