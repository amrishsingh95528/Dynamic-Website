package com.web.project.service;

import java.util.List;

import com.web.project.entity.Message;

public interface MessageService {
	void saveMessage(Message message);
	List <Message> getAllMessage();
	void deleteMessageById(long id);
	List<Message> getMessageCount();
}
