package controller;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private static final Logger log = Logger.getLogger(HomeController.class);


	@RequestMapping(value = "/")
	public ModelAndView home() throws IOException {
		log.info("sono in controller HOME");
		return new ModelAndView("homeSim");
	}

	@RequestMapping(value = "/page2")
	public ModelAndView page2() {
		log.info("sono in controller page2");
		return new ModelAndView("page2");
	}

}
