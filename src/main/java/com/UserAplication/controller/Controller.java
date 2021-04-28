package com.UserAplication.controller;

import java.util.List;
import java.util.Optional;

import com.UserAplication.services.ServiceImpl;
import com.UserAplication.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private ServiceImpl service;

	@RequestMapping("/")
	public String index(@ModelAttribute("user") UserDetails user) {

		return "index";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute("user") UserDetails user, RedirectAttributes re) {

		service.saveUser(user);
		re.addFlashAttribute("msg", "Registered successfully");

		return "redirect:/";

	}

	@RequestMapping("/show")
	public String showdata(Model model) {
        List<UserDetails> list = service.getAllUserData();
        model.addAttribute("list", list);
		return "showdata";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		Optional<UserDetails> user = service.getUserById(id);
		UserDetails data = user.get();
		model.addAttribute("data", data);
		return "update";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.deleteUserById(id);
		return "redirect:/show";
	}

	@RequestMapping( "/find")
	public String find(@Param("keyword") String keyword, Model model){
		List<UserDetails> u = service.findByUserName(keyword);
		model.addAttribute("u",u);
		return "showdata";
	}

}