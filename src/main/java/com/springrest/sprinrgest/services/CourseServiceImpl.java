package com.springrest.sprinrgest.services;
import java.util.ArrayList;
import java.util.List;
import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;
@Service //tells Spring Boot that this code also works as a Service Layer 
public class CourseServiceImpl implements CourseService {
	List<Course> data;
	public CourseServiceImpl() {
		data=new ArrayList<>();
		data.add(new Course(145,"Java Core Course","This Course contain basics of Java"));
		data.add(new Course(4345,"Spring Boot Course","Creating REST APIs using Spring Boot"));
	}
	@Override
	public List<Course> getCourses() {
		return data;
	}
	@Override
	public Course getCourse(long courseId) {
		Course c=null;
		for(Course course:data) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}
	@Override
	public Course addCourse(Course course) {
		data.add(course);
		return course;
	}
}
