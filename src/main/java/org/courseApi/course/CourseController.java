package org.courseApi.course;

import java.util.List;

import org.courseApi.exception.CourseNotFoundException;
import org.courseApi.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	private final String courseNotFound=" Course Not Found"; 
	
	@RequestMapping(method=RequestMethod.GET, value="/topics/{topicId}/courses")
	public ResponseEntity<List<Course>> getCourses(@PathVariable(value="topicId", required=true) String topicId){		
		return ResponseEntity.ok(courseRepository.findByTopicId(topicId));
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/topics/{topicId}/courses/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable String id) {
		
		Course course=null;
		if(courseRepository.findById(id).isPresent()) {
				course=courseRepository.findById(id).get();
		}
		if(null==course) {
			throw new CourseNotFoundException(404,id+courseNotFound);
		}
		
		return ResponseEntity.ok(course);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
		if(topicRepository.findById(topicId).isPresent())
			course.setTopic(topicRepository.findById(topicId).get());
		courseRepository.save(course);
		//TODO: Exception if topicId not found 
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@PathVariable String id, @RequestBody Course course, @PathVariable String topicId) {
		if(topicRepository.findById(topicId).isPresent())
			course.setTopic(topicRepository.findById(topicId).get());
		courseRepository.save(course);
		//TODO: Exception if topicId not found
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseRepository.deleteById(id);
	}
}
