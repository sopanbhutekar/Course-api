package org.courseApi.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value="/topics", method=RequestMethod.GET)
	public ResponseEntity<List<Topic>> getTopics(){
		return ResponseEntity.ok(topicService.getTopics());
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.GET)
	public ResponseEntity<Topic> getTopic(@PathVariable("id") String id) {
		Topic topic=topicService.getTopic(id);
		if(null==topic) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(topic);
	}
	
	@RequestMapping(value="/topics", method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}
