package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.domain.Member;
import com.web.repository.MemberRepository;



@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberRepository memberDao;
	
	@RequestMapping("/list")
	public String list(Model model){
		List<Member> list = memberDao.findAll();
		model.addAttribute("list",list);
		return "member/list";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add(){
		return "member/add";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String postAdd(Member member){
		memberDao.save(member);
		return "redirect:/member/list";
	}
	
	@RequestMapping(value="/mod/{id}",method = RequestMethod.GET)
	public String mod(@PathVariable int id, Model model){
		Member member = memberDao.findOne(id);
		model.addAttribute("data",member);
		return "member/mod";
	}
	
	@RequestMapping(value="/mod",method = RequestMethod.POST)
	public String postMod(Member member){
		memberDao.save(member);
		return "redirect:/member/list";
	}
	
	@RequestMapping("/del/{id}")
	public String del(@PathVariable int id){
		memberDao.delete(id);
		return "redirect:/member/list";
	}	
}