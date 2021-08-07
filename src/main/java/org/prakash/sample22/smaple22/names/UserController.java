package org.prakash.sample22.smaple22.names;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String homePage() {
		return "redirect:/index";
	}

	@GetMapping("/showform")
	public String showForm(User user) {
		return "show-form";
	}

	@PostMapping("/addname")
	public String addNames(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors())
			return "show-form";

		userRepository.save(user);
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String showNamesList(Model model) {
		log.debug(userRepository.findAll());
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
		model.addAttribute("user", user);
		return "update-user";
	}

	@PostMapping("/update/{id}")
	public String updateName(@PathVariable("id") long id, @Valid User user, BindingResult report, Model model) {
		if (report.hasErrors()) {
			user.setId(id);
			return "update-user";
		}

		userRepository.save(user);
		return "redirect:/index";

	}

	@GetMapping("/delete/{id}")
	public String deleteName(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));

		userRepository.delete(user);
		return "redirect:/index";

	}
}
