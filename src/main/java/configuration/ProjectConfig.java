package configuration;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "controller")
public class ProjectConfig {

	private static final Logger log = Logger.getLogger(ProjectConfig.class);

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public Object log4Jprop() {
		Properties props = new Properties();
		InputStream in = null;

		try {
			in = ProjectConfig.class.getClassLoader().getResourceAsStream("resources/log4j.properties");
			props.load(in);
			PropertyConfigurator.configure(props);
			for (Object dt : props.keySet()) {
				log.info(dt + ": " + props.getProperty((String) dt));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
