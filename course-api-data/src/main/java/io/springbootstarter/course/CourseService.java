package io.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	private List<Course> courses = new ArrayList<>(Arrays.asList(
			
			new Course("Spring","Spring","Spring Framework Description"),
			new Course("Docker","Docker","Docker Description"),
			new Course("Git","Git","Git Description")
			));
	
	public List<Course> getAllCourses(String topicId)
	{
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id)
	{
		Course t = courseRepository.findOne(id);
		return t;
	}
	
	public void addCourse(Course t)
	{
		courseRepository.save(t);
	}

	public void updateCourse(String id, Course c) {
		
		courseRepository.save(c);
	}
	
	public void deleteCourse
	(String id)
	{
		courseRepository.delete(id);
	}

}
