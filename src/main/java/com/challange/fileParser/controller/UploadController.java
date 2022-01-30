package com.challange.fileParser.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.challange.fileParser.entity.User;

@Controller
public class UploadController {

	@GetMapping("/")
	public String index() {
		return "homepage";
	}

	@GetMapping("/file-parser")
	public String fileParser() {
		return "file-parser";
	}

	@PostMapping("/upload-file")
	public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

		// validate file
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a file to upload.");
			model.addAttribute("status", false);
		} else {
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
				List<User> users = new ArrayList<User>();
				String line;
				while ((line = reader.readLine()) != null) {
					String[] tokens = line.split(",");
					User user = new User(Long.parseLong(tokens[0]), Integer.parseInt(tokens[1]), tokens[2]);
					users.add(user);
				}

				// save users list on model
				model.addAttribute("users", users);
				model.addAttribute("status", true);

			} catch (Exception ex) {
				model.addAttribute("message", "An error occurred while processing the CSV file.");
				model.addAttribute("status", false);
			}
		}

		return "file-upload-status";
	}

	

}