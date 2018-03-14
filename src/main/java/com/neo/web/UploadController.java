package com.neo.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.neo.config.Const;
import com.neo.entity.Attachment;
import com.neo.entity.Periodical;
import com.neo.entity.User;
import com.neo.json.AjaxJson;
import com.neo.service.AttachmentService;
import com.neo.service.PeriodicalService;
import com.neo.service.UserService;

@Controller
public class UploadController {

	@Autowired 
	public AttachmentService attachmentService;
	
	@Autowired
	public PeriodicalService periodicalService;
	
	@Autowired
	public UserService userService;
	
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "E://temp//";

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/uploadPeriodical") // //new annotation since 4.3
    public AjaxJson singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes,
                                   @RequestBody Periodical periodical,
                                  HttpServletRequest request) {
    	System.out.println("filePath===" + request.getParameter("filePath"));
    	String token = request.getHeader("token");
    	AjaxJson j = new AjaxJson();
    	User user = userService.findUserByToken(token);
    	if(user != null && periodical != null) {
    		if (file.isEmpty()) {
            	j.setSuccess(Const.FALSE);
            	j.setMessage(Const.UPLOAD_ERROR);
            	return j;
            }
            try {
                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                Attachment attachment = new Attachment();
                attachment.setFileName(path.getFileName().toString());
                attachment.setFilePath(UPLOADED_FOLDER + File.pathSeparator + path.getFileName().toString());
                attachmentService.save(attachment);
                periodical.setAttachmentId(attachment.getId());
                periodical.setPublishUserId(user.getId());
                periodical.setPublishUserName(user.getUserName());
                periodicalService.save(periodical);
                j.setSuccess(Const.TRUE);
                j.setMessage(Const.UPLOAD_SUCCESS);
                
            } catch (IOException e) {
            	j.setSuccess(Const.FALSE);
            	j.setMessage(Const.UPLOAD_ERROR);
            }
    	}else {
    		j.setSuccess(Const.FALSE);
        	j.setMessage(Const.UPLOAD_ERROR);
    	}
        return j;
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
    
    /**
     * 下载文件
     * @return
     */
    @GetMapping("/downloadPeriodical")
    public String downloadPeriodical(@RequestBody Periodical periodical) {
    	
        return "uploadStatus";
    }
    
    /**
     * 获取文件内容
     * @return
     */
    @GetMapping("/getPeriodicalContent")
    public String getPeriodicalContent(@RequestBody Periodical periodical) {
        return "uploadStatus";
    }

}