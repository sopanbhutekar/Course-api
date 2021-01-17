package org.courseApi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getTopics(){
		List<Topic> topics= new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);		
		return topics;
	}

	public Topic getTopic(String id) {
		if(topicRepository.findById(id).isPresent())
		return topicRepository.findById(id).get();
		
		return null;
	}

	public void addTopic(Topic topic) {
	topicRepository.save(topic);	
	}
	
	public void updateTopic(Topic topic, String id) {		
		topic.setId(id);
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
	
}
