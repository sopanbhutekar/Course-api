package org.courseApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics= new ArrayList<>(Arrays.asList(
			new Topic("java","java 8", "this new java tutorials"),
			new Topic("SpringBoot","spring framework using spring boot","spring framework using spring boot"),
			new Topic("javaScript","javaScript tutorials","javaScript tutorials")
			));
	
	public List<Topic> getTopics(){
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
	topics.add(topic);		
	}
	
	public void updateTopic(Topic topic, String id) {
		for(int i=0; i<topics.size();i++) {
			if(topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}
	
	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
	
}
