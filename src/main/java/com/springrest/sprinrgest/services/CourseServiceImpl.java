package com.springrest.sprinrgest.services;
import org.springframework.beans.factory.annotation.Autowired;
//import java.util.ArrayList;
import java.util.List;
import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;
@Service //tells Spring Boot that this code also works as a Service Layer 
public class CourseServiceImpl implements CourseService {
	@Autowired //Automatic Wiring, it injects dependency
	private CourseDao courseDao;
	//List<Course> data;
	public CourseServiceImpl() {
//		data=new ArrayList<>();
//		data.add(new Course(145,"Java Core Course","This Course contain basics of Java"));
//		data.add(new Course(4345,"Spring Boot Course","Creating REST APIs using Spring Boot"));
	}
	@Override
	public List<Course> getCourses() {
		//return data;
		return courseDao.findAll();
	}
	@Override
	public Course getCourse(long courseId) {
//		Course c=null;
//		for(Course course:data) {
//			if(course.getId()==courseId) {
//				c=course;
//				break;
//			}
//		}
//		return c;
		return courseDao.getReferenceById(courseId);
	}
	@Override
	public Course addCourse(Course course) {
		//data.add(course);
		courseDao.save(course);
		return course;
	}
	@Override
	public Course updateCourse(Course course) {
//		data.forEach(e->{
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
		return course;
	}
	@Override
	public void deleteCourse(long courseId) {
//		List<Course> newData=new ArrayList<>();
//		for(Course course:data) {
//			if(course.getId()==courseId) {
//				continue;
//			}else {
//				newData.add(course);
//			}
//		}
//		data=newData;
		Course entity=courseDao.getReferenceById(courseId);
		courseDao.delete(entity);
	}
}
