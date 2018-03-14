package com.neo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

}