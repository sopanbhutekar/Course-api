package org.courseApi.topic;

import java.util.List;

import org.courseApi.exception.TopicNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class TopicController {
	
	
	@Autowired
	private TopicService topicService;
	
	private final String topicNotFound=" Topic Not Found";
	
	@RequestMapping(value="/topics", method=RequestMethod.GET)
	@ApiOperation(value="Get Topics", notes="Get all Available Topics", response=ResponseEntity.class)
	public ResponseEntity<List<Topic>> getTopics(){
		return ResponseEntity.ok(topicService.getTopics());
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.GET)
	@ApiOperation(value="Get Topic", notes="Get Available Topic", response=ResponseEntity.class)
	public ResponseEntity<Topic> getTopic(@PathVariable("id") String id) {
		Topic topic=topicService.getTopic(id);
		if(null==topic) {
			throw new TopicNotFoundException(id+topicNotFound,404);
		}		
		return ResponseEntity.ok(topic);
	}
	
	@RequestMapping(value="/topics", method=RequestMethod.POST)
	@ApiOperation(value="Add Topics", notes="Add new Topic", response=void.class)
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.PUT)
	@ApiOperation(value="Update Topics", notes="Update Available Topic", response=void.class)
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	@ApiOperation(value="Delete Topics", notes="Delete Available Topic", response=void.class)
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}
