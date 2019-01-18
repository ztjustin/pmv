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
import org.springframework.web.servlet.ModelAndView;

import com.pmv.entity.Cpu;
import com.pmv.service.CpuService;

@Controller
public class CpuController {
	
	private static final Log LOG = LogFactory.getLog(CpuController.class);
	
	@Autowired
	@Qualifier("cpuServiceImpl")
	private CpuService cpuServiceImpl;
	
	
	@GetMapping({"/admin/cpu"})
    public ModelAndView index() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView("cpus");
		model.addObject("username",user.getUsername());
		model.addObject("cpus",cpuServiceImpl.getAll());
		LOG.info("Esta es el detalle de los CPU " + cpuServiceImpl.getAll().toString());
		return model;
    }
	
	@GetMapping({"/admin/cpuEdit"})
    public String detailCpu(@RequestParam(name="cpuId",required = false) Long cpuId,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		if(cpuId == null  ||  cpuServiceImpl.exists(cpuId) == false) {
			 return "redirect:/admin/cpu";	
		}else {
			model.addAttribute("cpu",cpuServiceImpl.getOne(cpuId));
		}

		return "editCpu";
    }
	
	
	@PostMapping({"/admin/addOrEditCpu"})
    public String addOrEditCpu(@ModelAttribute(name="Cpu") Cpu cpu,HttpServletRequest request,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		try {
			
			/*Cpu newCpu = cpu;
			newCpu.setPlatformDetail(cpuServiceImpl.getOne(cpu.getCpuId()).getPlatformDetail());*/
		
			cpuServiceImpl.addOne(cpu);
			model.addAttribute("success","success");
			return "editCpu";
			
		}catch(Exception ex) {
			model.addAttribute("error","error");
			LOG.info(ex.toString());
			return "editCpu";
		}

    }
	

}
