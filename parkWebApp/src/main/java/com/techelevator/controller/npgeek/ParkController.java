package com.techelevator.controller.npgeek;



import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDao;
import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.SurveyDao;
import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.WeatherDao;

@Controller
public class ParkController {

	@Autowired
	private ParkDao parkDao;
	@Autowired
	private WeatherDao weatherDao;
	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping ("/")
	public String displayHomePage(ModelMap modelMap) {
		modelMap.put("parks", parkDao.getAllParks());
		return "home";
	}
	
	@RequestMapping ("/home")
	public String displayHome(ModelMap modelMap) {
		modelMap.put("parks", parkDao.getAllParks());
		return "home";
	}

	@GetMapping("/detail")
	public String showParkDetail(@RequestParam String parkcode, ModelMap modelMap, HttpSession session) {
		Park detailPark = parkDao.getParkbyParkcode(parkcode);
		List<Weather> weather = weatherDao.getParkWeather(parkDao.getParkbyParkcode(parkcode));
		//session.setAttribute("scale", "celsius");
		//weather 
		modelMap.put("detailPark", detailPark);
		modelMap.put("weatherMap", weather);
		return "detail";
	}
	
	@PostMapping("/detail")
	public String getNewDetailPage (@RequestParam String temperature, @RequestParam String parkcode,  HttpSession session, ModelMap modelMap) {
		session.setAttribute("scale", temperature);
		Park detailPark = parkDao.getParkbyParkcode(parkcode);
		List<Weather> weather = weatherDao.getParkWeather(parkDao.getParkbyParkcode(parkcode));
		modelMap.put("detailPark", detailPark);
		modelMap.put("weatherMap", weather);
		return "redirect:/detail?parkcode="+parkcode;
	}
	
	
	@GetMapping("/survey")
	public String showSurveyPage(ModelMap modelMap) {
		if(modelMap.containsAttribute("survey") == false) {
			Survey empty = new Survey();
			modelMap.put("survey", empty);
		}
		return "survey";
	}
	
	@PostMapping("/survey")
	public String processSurveyForm (@Valid @ModelAttribute Survey survey, BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
				}
			redirectAttributes.addFlashAttribute("survey", survey);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			return ("redirect:/survey");
		} surveyDao.save(survey); 
		return ("redirect:/favorites");
	} 
	
	@RequestMapping("/favorites")
	public String getFavorites() {
		return "favorites";
	}
}
