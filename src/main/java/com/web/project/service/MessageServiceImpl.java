package com.web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.project.entity.Message;
import com.web.project.repository.MessageRepository;
@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageRepository messageRepository;

	@Override
	public void saveMessage(Message message) {
		this.messageRepository.save(message);

	}

	@Override
	public List<Message> getAllMessage() {
		return messageRepository.findAll();
	}

	@Override
	public void deleteMessageById(long id) {
		this.messageRepository.deleteById(id);
		
	}

	@Override
	public List<Message> getMessageCount() {
		return messageRepository.findAll();
	}
	
	
}
