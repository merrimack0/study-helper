package com.merrimack.studyhelper;

import com.merrimack.studyhelper.domain.study.Study;
import com.merrimack.studyhelper.domain.user.request.StudyRequest;
import com.merrimack.studyhelper.service.study.StudyService;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudyhelperApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class StudyServiceTest {

    @Autowired
    private StudyService studyService;

    @Test
    public void createStudy() {
        List<Long> times = Arrays.asList(1L,2L);
        StudyRequest studyRequest = new StudyRequest();
        studyRequest.setTitle("제목");
        studyRequest.setContent("내용");
        studyRequest.setMax(8L);
        studyRequest.setTimeId(times);

        studyService.createStudy(studyRequest);

        List<Study> study = studyService.findByTitleAndContent(studyRequest.getTitle(), studyRequest.getContent());
        assertThat(study.size()).isEqualTo(1);
    }
}
