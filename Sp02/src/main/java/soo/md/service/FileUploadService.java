package soo.md.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	boolean writeFile(MultipartFile file, String saveFileName);
	String saveStore(MultipartFile file);	
	
}
