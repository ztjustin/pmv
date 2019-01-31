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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pmv.entity.Cpu;
import com.pmv.entity.PlatformDetail;
import com.pmv.service.CpuService;
import com.pmv.service.PchService;
import com.pmv.service.PlatformDetailService;
import com.pmv.service.PlatformService;
import com.pmv.service.UserService;


@Controller
public class PlatformDetailController {
	
	private static final Log LOG = LogFactory.getLog(PlatformDetailController.class);
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("platformDetailServiceImpl")
	private PlatformDetailService platformDetailServiceImpl;
	
	@Autowired
	@Qualifier("platformServiceImpl")
	private PlatformService platformServiceImpl;
	
	@Autowired
	@Qualifier("pchServiceImpl")
	private PchService pchServiceImpl;
	
	@Autowired
	@Qualifier("cpuServiceImpl")
	private CpuService cpuServiceImpl;
	
	
	@GetMapping({"/admin/platformDetail"})
    public ModelAndView index(@RequestParam(name="platformId",required = true) Long platformId) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView("detailplatform");
		model.addObject("username",user.getUsername());
		model.addObject("platformDetail",platformDetailServiceImpl.getPlatformDetailByPlatformId(platformId));
		LOG.info("Detalles de las plataformas");
		return model;
    }
	
	
	@PostMapping({"/admin/platformDetail/AddPlatformToPch"})
    public String updatePlatformDetailToPch(@RequestParam(name="platformId",required = false) Long platformId,
    		@RequestParam(name="pchId",required = false) Long pchId,HttpServletRequest request,Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username",user.getUsername());
		
		try {
			
			model.addAttribute("platform",platformServiceImpl.getOne(platformId));
			model.addAttribute("pchs",pchServiceImpl.getAll());
			
			PlatformDetail newDetailPlatform = platformDetailServiceImpl.getPlatformDetailByPlatformId(platformId);
			newDetailPlatform.setPch(pchServiceImpl.getOne(pchId));
			Date localDate = new Date();
			newDetailPlatform.setLastUpdate(localDate);
			platformDetailServiceImpl.addOne(newDetailPlatform);
			model.addAttribute("success","success");
			model.addAttribute("pchs",pchServiceImpl.getAll());
			return "AddPch";
			
		}catch(DataIntegrityViolationException ex) {
			
			model.addAttribute("duplicate","The pch is located in the platform " + pchServiceImpl.getOne(pchId).getPlatformDetail().getPlatform().getName());
			LOG.info(ex.toString());
			return "AddPch";
		}

    }
	

}
