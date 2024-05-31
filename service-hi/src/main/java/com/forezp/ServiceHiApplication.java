package com.forezp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SpringBootApplication

@RestController
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Value("8762")
	String port;
	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi "+name+",i am from port:" +port;
	}

	@RequestMapping("/download")
	public HttpServletResponse download(HttpServletResponse response) {
		String filePath = "C:\\Users\\hcf\\Desktop\\pushSF0521.xlsx";

		try (InputStream fis = new BufferedInputStream(new FileInputStream(filePath));
			 OutputStream toClient = new BufferedOutputStream(response.getOutputStream())) {
			File file = new File(filePath);
			String filename = file.getName();
			response.reset();
			response.setHeader("Content-Disposition", "attachment; filename=" + filename);
			response.setContentType("application/octet-stream");

			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {
				toClient.write(buffer, 0, bytesRead);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return response;
	}


}
