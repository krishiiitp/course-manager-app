package com.springrest.springrest.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.springrest.springrest.entities.Course;
import com.springrest.sprinrgest.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
@RestController
public class MyController {
	@Autowired //tells Spring Boot to create object
	private CourseService courseService;
	@GetMapping("/home")
	public String home() {
		return "Welcome to Course Manager Application";
	}
	
	//Get Courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
	}
	
	//Get a Course by CourseID
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	//Add a course (POST Method)
	@PostMapping(path="/courses",consumes="application/json")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	//Update a Course (PUT Method)
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	//Delete a Course by CourseId (DELETE Method)
//	@DeleteMapping("courses/{courseId}")
//	public String deleteCourse(@PathVariable String courseId) {
//		boolean ans=this.courseService.deleteCourse(Long.parseLong(courseId));
//		if(ans) {
//			return "Course with Course ID : "+courseId+" has been Deleted successfully";
//		}
//		return "Course with Course ID : "+courseId+" does not exist!!";
//	}
	
	@DeleteMapping("courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
