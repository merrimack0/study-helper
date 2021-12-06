package com.merrimack.studyhelper.domain.study;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {
    public List<Study> findByTitleAndContent(String title, String content);
}
