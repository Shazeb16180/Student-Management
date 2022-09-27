package com.projects.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projects.commons.CustomValidation;
import com.projects.commons.LocalDatePropertyEditor;
import com.projects.entity.Student;
import com.projects.entity.StudentModel;
import com.projects.entity.User;
import com.projects.service.IStudentService;
import com.projects.service.IUserService;

@Controller
public class CustomController {
	@Autowired
	private IStudentService studentService;

	@Autowired
	private CustomValidation validator;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/showLogin")
	public String getLoginPage() {
		return "login";
	}

	@GetMapping("/")
	public String getAllStudents(
			@PageableDefault(page = 0, size = 4, direction = Direction.ASC, sort = "studentName") Pageable page,
			Map<String, Object> map) {
		map.put("students", studentService.getAllStudents(page));
		return "student_home";

	}

	@GetMapping("/add")
	public String addStudentForm(@ModelAttribute StudentModel studentModel) {
		return "add_student";
	}

	@PostMapping("/add")
	public String addStudent(@ModelAttribute StudentModel studentModel, BindingResult error, RedirectAttributes map)
			throws IOException {
		String location="C:/resume";
		File resumeFile = new File( location);
		if (!resumeFile.exists())
			resumeFile.mkdir();
		MultipartFile resumeMultipart = studentModel.getResumeLocation();
		Student student = new Student();
		BeanUtils.copyProperties(studentModel, student, "resumeLocation");
		student.setResumeLocation(resumeMultipart.isEmpty()?"":location+"/"+resumeMultipart.getOriginalFilename());
		if (validator.supports(Student.class))
			validator.validate(student, error);
		if (error.hasErrors())
			return "add_student";
		InputStream resumInput = resumeMultipart.getInputStream();
		OutputStream os = new FileOutputStream(resumeFile + "/" + resumeMultipart.getOriginalFilename());
		IOUtils.copy(resumInput, os);
		resumInput.close();
		os.close();
		map.addFlashAttribute("message", studentService.addStudent(student));
		return "redirect:/";
	}

	@GetMapping("/edit")
	public String getEdit(@RequestParam Integer id, @ModelAttribute StudentModel studentModel, Map<String, Object> map)
			throws IOException {
		BeanUtils.copyProperties(studentService.getStudent(id), studentModel, "resumeLocation");
		return "edit_student";
	}

	@PostMapping("/edit")
	public String editStudent(@ModelAttribute StudentModel studentModel, BindingResult error, RedirectAttributes map)
			throws IOException {
		Student student = new Student();
		BeanUtils.copyProperties(studentModel, student, "resumeLocation");
		String  resumeLocation= studentService.getStudent(studentModel.getId()).getResumeLocation();
		student.setResumeLocation(resumeLocation);
		if (validator.supports(Student.class))
			validator.validate(student, error);
		if (error.hasErrors())
			return "add_student";
		map.addFlashAttribute("message", studentService.editStudent(student));
		return "redirect:/";
	}

	@GetMapping("/delete")
	public String getEdit(@RequestParam Integer id, RedirectAttributes rd) {
		rd.addFlashAttribute("message", studentService.deletetStudent(id));
		return "redirect:/";
	}
	
	@GetMapping("/download")
	public String download(@RequestParam Integer id ,HttpServletResponse response) throws IOException {
		String resumeLocation= studentService.getStudent(id).getResumeLocation();
		File file=new File(resumeLocation);
		response.setContentLengthLong(file.length());
		String mimeType= servletContext.getMimeType(resumeLocation);
		mimeType= mimeType!=null?mimeType:"application/octet-stream";
		response.setContentType(mimeType);
		
		
		response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
		InputStream is = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		//res.setHeader("Content-Disposition", "attachment;fileName=" + downloadFile.getName());
		IOUtils.copy(is, os);
		is.close();
		os.close();

		return null;		
	}
	@GetMapping("/register")
	public String getRegistration() {
		return "register";
	}
	
	@PostMapping("/register")
	public String postRegister(@ModelAttribute User user) {
		return "redirect:/showLogin?register="+userService.addUser(user);
		
	}

	@ModelAttribute("countries")
	public Set<String> getCountries() {
		return studentService.getCountries();

	}

	@ModelAttribute("color")
	public Set<String> getColor() {
		return studentService.getHouseColor();

	}

	@InitBinder
	public void registerPropertyEditor(WebDataBinder web) {
		web.registerCustomEditor(LocalDate.class, new LocalDatePropertyEditor());

	}
}
