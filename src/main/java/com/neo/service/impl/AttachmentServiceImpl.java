package com.neo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.entity.Attachment;
import com.neo.repository.AttachmentRepository;
import com.neo.service.AttachmentService;

@Service
public class AttachmentServiceImpl implements AttachmentService{

	@Autowired
	public AttachmentRepository repository;

	@Override
	public Attachment findAttachmentById(long id) {
		return repository.findOne(id);
	}

	@Override
	public Attachment save(Attachment attachment) {
		return repository.save(attachment);
	}

	@Override
	public void edit(Attachment attachment) {
		repository.save(attachment);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	} 
}


