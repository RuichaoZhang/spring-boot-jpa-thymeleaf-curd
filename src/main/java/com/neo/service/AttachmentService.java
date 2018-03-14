package com.neo.service;

import com.neo.entity.Attachment;

public interface AttachmentService {


    public Attachment findAttachmentById(long id);
    
    public Attachment save(Attachment attachment);

    public void edit(Attachment attachment);

    public void delete(long id);

}
