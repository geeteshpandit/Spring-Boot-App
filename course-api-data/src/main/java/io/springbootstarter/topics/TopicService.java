package io.springbootstarter.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			
			new Topic("Spring","Spring","Spring Framework Description"),
			new Topic("Docker","Docker","Docker Description"),
			new Topic("Git","Git","Git Description")
			));
	
	public List<Topic> getAllTopics()
	{
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		Topic t = topicRepository.findOne(id);
		return t;
	}
	
	public void addTopic(Topic t)
	{
		topicRepository.save(t);
	}

	public void updateTopic(String id, Topic t) {
		
		topicRepository.save(t);
	}
	
	public void deleteTopic(String id)
	{
		for(int i =0; i< topics.size(); i++)
		{
			if(topics.get(i).getId().equals(id))
			{
				topics.remove(i);
			}
		}
	}

}
