package com.merrimack.studyhelper.service.study;

import com.merrimack.studyhelper.domain.enumclass.DisplayStatus;
import com.merrimack.studyhelper.domain.study.Study;
import com.merrimack.studyhelper.domain.study.StudyRepository;
import com.merrimack.studyhelper.domain.user.request.CreateStudy;
import com.merrimack.studyhelper.domain.user.request.UserRequest;
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

    public void createStudy(CreateStudy createStudy) {
        createStudy.validate();

        Study study = Study.builder()
                .title(createStudy.getTitle())
                .content(createStudy.getContent())
                .max(createStudy.getMax())
                .displayStatus(DisplayStatus.OPEN)
                .build();

        studyRepository.save(study);

    }

    public void joinStudy(UserRequest userRequest) {

    }

    public List<Study> findAll() {
        return studyRepository.findAll();
    }
}
