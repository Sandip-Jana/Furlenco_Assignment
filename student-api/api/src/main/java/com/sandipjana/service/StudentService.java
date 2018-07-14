package com.sandipjana.service;

import com.sandipjana.model.Student;
import com.sandipjana.repository.StudentRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public List<Student> checkForParams(Map<String, String> allRequestParams) {
    if (allRequestParams.isEmpty()) {
      return null;
      //return getAllStudents();
    } else {
      return getSelectedStudents(allRequestParams);
    }
  }

  public List<Student> getSelectedStudents(Map<String, String> params) {
    List<Student> gradeResultList = new ArrayList<>();
    List<Student> activeResultList = new ArrayList<>();
    List<Student> admissionYearBeforeResultList = new ArrayList<>();
    List<Student> admissionYearAfterResultList = new ArrayList<>();
    if (params.containsKey("classes")) {
      String[] gradesArray = params.get("classes").split(",");
      IntStream intStream = Arrays.asList(gradesArray).stream().mapToInt(Integer::parseInt);
      List<Integer> gradesList = intStream.boxed().collect(Collectors.toList());
      ListIterator<Integer> itr = gradesList.listIterator();
      while (itr.hasNext()) {
        List<Student> gradeList = studentRepository.findByGrade(itr.next());
        gradeResultList.addAll(gradeList);
      }
    }
    if (params.containsKey("active")) {
      activeResultList = studentRepository.findByActive(Boolean.valueOf(params.get("active")));
    }
    if(params.containsKey("admissionYearBefore")){
      Map<String,String> date = new HashMap<>();
      date.put("admissionYearBefore",params.get("admissionYearBefore"));
      admissionYearBeforeResultList = getAllStudentsBeforeDate(date);
    }
    if(params.containsKey("admissionYearAfter")){
      Map<String,String> date = new HashMap<>();
      date.put("admissionYearAfter",params.get("admissionYearAfter"));
      admissionYearAfterResultList = getAllStudentsAfterDate(date);
    }
    List<Student> result = new ArrayList<>();
    if (params.containsKey("classes")) {
      result.addAll(gradeResultList);
      result.retainAll(params.containsKey("active") ? activeResultList : result);
      result.retainAll(params.containsKey("admissionYearBefore") ? admissionYearBeforeResultList : result);
      result.retainAll(params.containsKey("admissionYearAfter") ? admissionYearAfterResultList : result);
    } else if (params.containsKey("active")) {
      result.addAll(activeResultList);
      result.retainAll(params.containsKey("classes") ? gradeResultList : result);
      result.retainAll(params.containsKey("admissionYearBefore") ? admissionYearBeforeResultList : result);
      result.retainAll(params.containsKey("admissionYearAfter") ? admissionYearAfterResultList : result);
    }
    else if (params.containsKey("admissionYearBefore")){
      result.addAll(admissionYearBeforeResultList);
      result.retainAll(params.containsKey("classes") ? gradeResultList : result);
      result.retainAll(params.containsKey("active") ? activeResultList : result);
      result.retainAll(params.containsKey("admissionYearAfter") ? admissionYearAfterResultList : result);
    }
    else if(params.containsKey("admissionYearAfter")){
      result.addAll(admissionYearAfterResultList);
      result.retainAll(params.containsKey("classes") ? gradeResultList : result);
      result.retainAll(params.containsKey("active") ? activeResultList : result);
      result.retainAll(params.containsKey("admissionYearBefore") ? admissionYearAfterResultList : result);
    }
    return result;
  }

  public Page<Student> getAllStudentsWithDefaultPagination() {
    int size = 20;
    int currentPage = 0;
    Sort sort = new Sort(Direction.ASC, "id");
    PageRequest request = PageRequest.of(currentPage, size, sort);
    Page<Student> page = studentRepository.findAll(request);
    return page;
  }

  public Optional<Student> getStudentById(Long id) {
    return studentRepository.findById(id);
  }

  public Object saveStudent(Student student) {
    student.setActive(true);
    try {
      if (!student.getName().isEmpty() && !student.getadmissionyear().toString().isEmpty()
          && !Integer.toString(student.getGrade()).isEmpty()) {
        return studentRepository.save(student);
      } else {
        return null;
      }
    } catch (Exception e) {
      return null;
    }

  }

  public boolean updateStudent(long id, int grade) {
    try {
      Optional<Student> student = getStudentById(id);
      Student student1 = student.get();
      student1.setGrade(grade);
      Student save = studentRepository.save(student1);
      return true;
    } catch (Exception e) {
      return false;
    }
  }


  public boolean deleteStudent(long id) {
    try {
      Optional<Student> student = getStudentById(id);
      Student student1 = student.get();
      student1.setActive(false);
      Student save = studentRepository.save(student1);
      return true;
    } catch (Exception e) {
      return false;
    }
  }


  public Page<Student> getAllStudentsWithCustomPagination(String pageSize, String pageNumber) {
    Sort sort = new Sort(Direction.ASC, "id");
    PageRequest request = PageRequest
        .of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), sort);
    Page<Student> page = studentRepository.findAll(request);
    return page;
  }

  public List<Student> getAllStudentsAfterDate(
      Map<String, String> allRequestParams) {
    int year = Integer.parseInt(allRequestParams.get("admissionYearAfter")) - 1900;
    Date date = new Date();
    date.setYear(year);
    return studentRepository.findByAdmissionYearAfter(date);
  }

  public List<Student> getAllStudentsBeforeDate(
      Map<String, String> allRequestParams) {
    int year = Integer.parseInt(allRequestParams.get("admissionYearBefore")) - 1900;
    Date date = new Date();
    date.setYear(year);
    return studentRepository.findByAdmissionYearBefore(date);
  }

}
