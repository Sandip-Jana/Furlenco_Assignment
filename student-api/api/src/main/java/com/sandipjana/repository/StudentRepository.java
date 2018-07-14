package com.sandipjana.repository;

import com.sandipjana.model.Student;
import com.sun.org.apache.xpath.internal.operations.Bool;
import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

  List<Student> findAll();
  List<Student> findByGrade(Integer grade);
  List<Student> findByActive(Boolean active);
  Optional<Student> findById(Long id);
  List<Student> findByAdmissionYearAfter(Date date);
  List<Student> findByAdmissionYearBefore(Date date);
  @Override
  <S extends Student> S save(S entity);

  void deleteById(Long id);
}
