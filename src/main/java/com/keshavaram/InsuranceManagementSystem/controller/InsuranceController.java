package com.keshavaram.InsuranceManagementSystem.controller;

import aj.org.objectweb.asm.Handle;
import com.keshavaram.InsuranceManagementSystem.chainOfRes.Handler;
import com.keshavaram.InsuranceManagementSystem.domain.Insurance;
import com.keshavaram.InsuranceManagementSystem.domain.User;
import com.keshavaram.InsuranceManagementSystem.facade.GetApproval;
import com.keshavaram.InsuranceManagementSystem.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InsuranceController {
	@Autowired
	private InsuranceService service;

	@GetMapping("/managePolicy")
	public String viewHomePage(Model model)
	{
		List<Insurance> listOfInsurances = service.listAll();
		model.addAttribute("listOfInsurance",listOfInsurances);
		return "managePolicyHomePage";
	}

	@GetMapping("/new")
	public String add(Model model)
	{
		model.addAttribute("insurance",new Insurance());
		return "BuyNewPolicyPage";
	}

	@RequestMapping("/search")
	public String search(Model model)
	{
		model.addAttribute("searchInsurance",new Insurance());
		return "search";
	}

	@RequestMapping(value = "/findPolicy", method = RequestMethod.POST)
	public String findPolicy(@ModelAttribute("searchInsurance") Insurance policy, Model model)
	{
		List<Insurance> allPolicies = service.listAll();
		List<Insurance> resultPolicies = new ArrayList<>();
		for (Insurance i :
			allPolicies) {
			if(i.getPolicyType().equals(policy.getPolicyType()))
			{
				resultPolicies.add(i);
			}
		}
		model.addAttribute("searchResults", resultPolicies);
		return "searchRes";
	}

	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveInsurance(@ModelAttribute("insurance") Insurance policy)
	{
		Handler handler = new Handler(policy.getPremium());
		GetApproval getApproval = new GetApproval(policy.getPremium(), User.getUserInstance().getUsername());
		if (handler.handle() && getApproval.approve()) {
			service.save(policy);
			return "redirect:/managePolicy";
		}
		return "redirect:/managePolicy?error";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditInsurancePage(@PathVariable(name = "id") int policyId) {
		ModelAndView mav = new ModelAndView("BuyNewPolicyPage");
		Insurance policy = service.get(policyId);
		mav.addObject("insurance", policy);
		return mav;

	}
	@RequestMapping("/delete/{id}")
	public String deletePolicy(@PathVariable(name = "id") int policyId) {
		service.delete(policyId);
		return "redirect:/managePolicy";
	}
}
