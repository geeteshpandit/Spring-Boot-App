package io.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.springbootstarter.topics.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{topicid}/courses")
	private List<Course> getAllCourses(@PathVariable String topicid)
	{
		return courseService.getAllCourses(topicid);
	}
	
	@RequestMapping("/topics/{topicid}/courses/{id}")
	private Course getCourse(@PathVariable String id)
	{
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicid}/courses/" )
	private void addCourse(@RequestBody Course c, @PathVariable String topicid)
	{
		c.setTopic(new Topic(topicid, "", ""));
		courseService.addCourse(c);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicid}/courses/{id}" )
	private void updateTopic(@RequestBody Course c, @PathVariable String id, @PathVariable String topicid )
	{
		c.setTopic(new Topic(topicid, "", ""));
		courseService.updateCourse(id,c);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicid}/courses/{id}" )
	private void deleteTopic(@PathVariable String id)
	{
		courseService.deleteCourse(id);
	}
}
