package com.shopme;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopme.banner.BannerService;
import com.shopme.category.CategoryService;
import com.shopme.common.entity.Banner;
import com.shopme.common.entity.Category;
import com.shopme.common.entity.Customer;
import com.shopme.customer.CustomerRepository;

@Controller
public class MainController {

	@Autowired private CategoryService categoryService;
	
	@Autowired
	private BannerService bannerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@GetMapping("")
	public String viewHomePage(Model model) {
		List<Banner> listBanners =bannerService.getAllBanners();
		List<Category> listCategories = categoryService.listNoChildrenCategories();
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("listBanners",listBanners);
		
		return "index";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
	    Customer customer = customerRepo.findByEmail(username);

	    if (customer == null || !passwordEncoder.matches(password, customer.getPassword())) {
	        return "redirect:/login?error=invalidCredentials";
	    }

	    if (!customer.isEnabled()) {
	        session.invalidate();
	        return "redirect:/login?error=accountDisabled";
	    }

	    session.setAttribute("customer", customer);
	    return "redirect:/";
	}

	
	
	@GetMapping("/login")
	public String viewLoginPage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		
		return "redirect:/";
	}	
}
