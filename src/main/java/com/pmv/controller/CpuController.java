package com.pmv.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
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

import com.pmv.entity.Cpu;
import com.pmv.entity.PlatformDetail;
import com.pmv.service.CpuService;
import com.pmv.service.PlatformDetailService;
import com.pmv.service.PlatformService;

@Controller
public class CpuController {
	
	private static final Log LOG = LogFactory.getLog(CpuController.class);
	
	@Autowired
	@Qualifier("cpuServiceImpl")
	private CpuService cpuServiceImpl;
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	@Autowired
	@Qualifier("platformDetailServiceImpl")
	private PlatformDetailService platformDetailServiceImpl;
	
	
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
	
	/*For ajax method*/
	@GetMapping({"/admin/getOneCpu"})
	@ResponseBody
    public Cpu getOnePch(@RequestParam(name="cpuId",required = false) Long cpuId) {
		
		Cpu cpu = new Cpu();
		if(cpuId == null  ||  cpuServiceImpl.exists(cpuId) == false) {
			 return null;	
		}else {
			cpu = cpuServiceImpl.getOne(cpuId);
		}
		
		return cpu;
    }
	
	@GetMapping({"/admin/addCpuToPlatform"})
    public String addcpuToPlatform(@RequestParam(name="platformId",required = false) Long platformId,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		if(platformId == null  ||  platformServiceImpl.exists(platformId) == false) {
			 return "redirect:/admin/cpu";	
		}else {
			model.addAttribute("cpus",cpuServiceImpl.getAll());
			model.addAttribute("platform",platformServiceImpl.getOne(platformId));
			return "AddCpu";
		}

    }
	
	
	@PostMapping({"/admin/addOrEditCpu"})
    public String addOrEditCpu(@ModelAttribute(name="Cpu") Cpu cpu,HttpServletRequest request,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		try {
			
			cpuServiceImpl.addOne(cpu);
			model.addAttribute("success","success");
			return "editCpu";
			
		}catch(Exception ex) {
			model.addAttribute("error","error");
			LOG.info(ex.toString());
			return "editCpu";
		}

    }
	
	
	@PostMapping({"/admin/cpu/AddPlatformToCpu"})
    public String updatePlatformDetailCpu(@RequestParam(name="platformId",required = false) Long platformId,
    		@RequestParam(name="cpuId",required = false) Long cpuId,HttpServletRequest request,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		try {
			
			
			model.addAttribute("platform",platformServiceImpl.getOne(platformId));
			model.addAttribute("cpus",cpuServiceImpl.getAll());
			
			Cpu updatePlatformCpu = new Cpu();
			updatePlatformCpu = cpuServiceImpl.getOne(cpuId);
			
			PlatformDetail newDetailPlatform = platformDetailServiceImpl.getPlatformDetailByPlatformId(platformId);
			Date localDate = new Date();
			newDetailPlatform.setLastUpdate(localDate);
			updatePlatformCpu.setPlatformDetail(newDetailPlatform);
			cpuServiceImpl.addOne(updatePlatformCpu);
			model.addAttribute("success","success");
			return "AddCpu";
			
		}catch(DataIntegrityViolationException ex) {
			
			model.addAttribute("duplicate","The pch is located in the platform " + cpuServiceImpl.getOne(cpuId).getPlatformDetail().getPlatform().getName());
			LOG.info(ex.toString());
			return "AddCpu";
		}

    }
	
	
	

}
