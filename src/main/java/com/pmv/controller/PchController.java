package com.pmv.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pmv.entity.Pch;
import com.pmv.service.PchService;
import com.pmv.service.PlatformService;

@Controller
public class PchController {
	
	private static final Log LOG = LogFactory.getLog(PchController.class);
	
	@Autowired
	@Qualifier("pchServiceImpl")
	private PchService pchServiceImpl;
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	@GetMapping({"/admin/pch"})
    public ModelAndView index() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView("pchs");
		model.addObject("username",user.getUsername());
		model.addObject("pchs",pchServiceImpl.getAll());
		LOG.info("Esta es el detalle de la plataforma " + pchServiceImpl.getAll().toString());
		return model;
    }
	
	@GetMapping({"/admin/pchEdit"})
    public String editPch(@RequestParam(name="pchId",required = false) Long pchId,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		if(pchId == null  ||  pchServiceImpl.exists(pchId) == false) {
			 return "redirect:/admin/pch";	
		}else {
			model.addAttribute("pch",pchServiceImpl.getOne(pchId));
		}

		return "editPch";
    }
	
	/*For ajax method*/
	@GetMapping({"/admin/getOnePch"})
	@ResponseBody
    public Pch getOnePch(@RequestParam(name="pchId",required = false) Long pchId) {
		
		Pch pch = new Pch();
		if(pchId == null  ||  pchServiceImpl.exists(pchId) == false) {
			 return null;	
		}else {
			pch = pchServiceImpl.getOne(pchId);
		}
		
		return pch;
    }
	
	
	@GetMapping({"/admin/addPchToPlatform"})
    public String addPchToPlatform(@RequestParam(name="platformId",required = false) Long platformId,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		if(platformId == null  ||  platformServiceImpl.exists(platformId) == false) {
			 return "redirect:/admin/pch";	
		}else {

			model.addAttribute("platform",platformServiceImpl.getOne(platformId));
			model.addAttribute("pchs",pchServiceImpl.getAll());
		}

		return "AddPch";
    }
	
	
	@PostMapping({"/admin/addOrEditPch"})
    public String addOrEditPch(@ModelAttribute(name="Pch") Pch pch,HttpServletRequest request,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		try {
			pchServiceImpl.addOne(pch);
			model.addAttribute("success","success");
			return "editPch";
		}catch(Exception ex) {
			model.addAttribute("error","error");
			return "editPch";
		}

    }
	
	
	

}
