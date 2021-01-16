package org.courseApi.course;

import java.util.List;

import org.courseApi.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private TopicRepository topicRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/topics/{topicId}/courses")
	public List<Course> getCourses(@PathVariable(value="topicId", required=true) String topicId){
		return courseRepository.findByTopicId(topicId);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseRepository.findById(id).get();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(topicRepository.findById(topicId).get());
		courseRepository.save(course);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@PathVariable String id, @RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(topicRepository.findById(topicId).get());
		courseRepository.save(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseRepository.deleteById(id);
	}
}
