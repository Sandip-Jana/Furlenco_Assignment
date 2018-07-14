package com.sandipjana.controller;

import com.sandipjana.model.Student;
import com.sandipjana.model.UpdateStudentModel;
import com.sandipjana.service.StudentService;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired
  StudentService studentService;

  @GetMapping(params = {"pageSize","pageNumber"})
  public Page<Student> getAllStudentsWithCustomPagination(@RequestParam String pageSize, String pageNumber) {
  	try {
    	
    	return studentService.getAllStudentsWithCustomPagination(pageSize,pageNumber);
	
	} catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }

  @GetMapping(params = {"classes","active","admissionYearAfter","admissionYearBefore"})
  public List<Student> getSelectedStudents4(@RequestParam Map<String, String> allRequestParams) {
  	try {
    	
    	return studentService.getSelectedStudents(allRequestParams);
	
	} catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}	
  }
  @GetMapping(params = {"classes","active","admissionYearAfter"})
  public List<Student> getSelectedStudents5(@RequestParam Map<String, String> allRequestParams) {
    try {
    
    	return studentService.getSelectedStudents(allRequestParams);
	
	} catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }
  @GetMapping(params = {"classes","active","admissionYearBefore"})
  public List<Student> getSelectedStudents6(@RequestParam Map<String, String> allRequestParams) {
    try {
    
    	return studentService.getSelectedStudents(allRequestParams);
    
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }
  @GetMapping(params = {"classes","admissionYearBefore","admissionYearAfter"})
  public List<Student> getSelectedStudents7(@RequestParam Map<String, String> allRequestParams) {
    try {
    
    	return studentService.getSelectedStudents(allRequestParams);
    
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }
  @GetMapping(params = {"active","admissionYearBefore","admissionYearAfter"})
  public List<Student> getSelectedStudents8(@RequestParam Map<String, String> allRequestParams) {
    try {
    
    	return studentService.getSelectedStudents(allRequestParams);
    
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }

  @GetMapping(params = {"classes","active"})
  public List<Student> getSelectedStudents3(@RequestParam Map<String, String> allRequestParams) {
    try {
    	
    	return studentService.getSelectedStudents(allRequestParams);
    
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }
  @GetMapping(params = {"classes","admissionYearBefore"})
  public List<Student> getSelectedStudents9(@RequestParam Map<String, String> allRequestParams) {
    try {
    	
    	return studentService.getSelectedStudents(allRequestParams);
    
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }
  @GetMapping(params = {"classes","admissionYearAfter"})
  public List<Student> getSelectedStudents10(@RequestParam Map<String, String> allRequestParams) {
    try {
    
    	return studentService.getSelectedStudents(allRequestParams);
    
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }
  @GetMapping(params = {"active","admissionYearBefore"})
  public List<Student> getSelectedStudents11(@RequestParam Map<String, String> allRequestParams) {
   	try {
   	
   	 	return studentService.getSelectedStudents(allRequestParams);
    
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }
  @GetMapping(params = {"active","admissionYearAfter"})
  public List<Student> getSelectedStudents12(@RequestParam Map<String, String> allRequestParams) {
    try {
    	
    	return studentService.getSelectedStudents(allRequestParams);
    
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }
  @GetMapping(params = {"admissionYearBefore","admissionYearAfter"})
  public List<Student> getSelectedStudents13(@RequestParam Map<String, String> allRequestParams) {
    try {
  	
  		  return studentService.getSelectedStudents(allRequestParams);
    
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }

  @GetMapping(params = "admissionYearAfter")
  public List<Student> getAllStudentsAfterDate(@RequestParam Map<String, String> allRequestParams) {
    try {
    	
    	return studentService.getAllStudentsAfterDate(allRequestParams);
    
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }
  @GetMapping(params = "admissionYearBefore")
  public List<Student> getAllStudentsBeforeDate(@RequestParam Map<String, String> allRequestParams) {
    try {
    	
    	return studentService.getAllStudentsBeforeDate(allRequestParams);
    
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }



  @GetMapping(params = "classes")
  public List<Student> getSelectedStudents1(@RequestParam Map<String, String> allRequestParams) {
  	try {

  		return studentService.getSelectedStudents(allRequestParams);
  	
  	} catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }

  @GetMapping(params = "active")
  public List<Student> getSelectedStudents2(@RequestParam Map<String, String> allRequestParams) {
    try {

    	return studentService.getSelectedStudents(allRequestParams);
    
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }

  @GetMapping
  public Page<Student> getAllStudentsWithDefaultPagination() {
    try {
    	
    	return studentService.getAllStudentsWithDefaultPagination();

    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }

  @GetMapping(value = "/{id}")
  public Object getStudentsById(@PathVariable String id) {
    try{
    	Optional<Student> student = studentService.getStudentById(Long.parseLong(id));
	    if (student.isPresent()) {
	      return student;
	    } else {
	      return new ResponseEntity(HttpStatus.NOT_FOUND);
	    }
	} catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }

  @PostMapping
  public ResponseEntity addStudent(@RequestBody Student student) {
    try {
	    Object obj = studentService.saveStudent(student);
	    System.out.println(obj);
	    if (obj != null) {
	      return new ResponseEntity(HttpStatus.CREATED);
	    } else {
	      return new ResponseEntity(HttpStatus.BAD_REQUEST);
	    }
	} catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }

  @PatchMapping(value = "/{id}")
  public ResponseEntity modifyStudent(@RequestBody UpdateStudentModel grade, @PathVariable String id) {
   try {
   		Boolean bool = studentService.updateStudent(Long.parseLong(id), grade.getGrade());
	    if (bool == true) {
	      return new ResponseEntity(HttpStatus.OK);
	    } else {
	      return new ResponseEntity(HttpStatus.BAD_REQUEST);
	    }
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity deleteStudent(@PathVariable String id){
    try{
	    Boolean bool=studentService.deleteStudent(Long.parseLong(id));
	    if (bool == true) {
	      return new ResponseEntity(HttpStatus.OK);
	    } else {
	      return new ResponseEntity(HttpStatus.BAD_REQUEST);
	    }
    } catch(Exception e) {
		System.out.println("Exception Caught "+e);
		return null;
	}
  }


}
