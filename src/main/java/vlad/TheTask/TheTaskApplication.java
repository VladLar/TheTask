package vlad.TheTask;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.MediaType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class TheTaskApplication {

	Logger logger = LoggerFactory.getLogger(TheTaskApplication.class);


	@RequestMapping(
			value = "/mirror",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public String mirror(@RequestBody String input) {

		logger.info("===== Processing request START");

		String result = "";

		JSONArray lines = null;
		JSONParser parser = new JSONParser();

		List<JSONArray> reversedLines = new JSONArray();

		try {
			logger.info("===== Processing request : parsing input : "  + input.getClass().getName() + " : '" + input + "'");

			lines = (JSONArray) parser.parse(input);

			logger.info("===== Processing request : input parsed : " + lines.getClass().getName() + " : '" + lines + "'");


			Iterator lineIterator = lines.iterator();
			while (lineIterator.hasNext()) {

				JSONArray line = (JSONArray) lineIterator.next();

				logger.info("===== Processing request : reversing line : "  + line.getClass().getName() + " : '" + line + "'");

				Collections.reverse(line);

				logger.info("===== Processing request : reversed line : "  + line.getClass().getName() + " : '" + line + "'");

				reversedLines.add(line);

			}
			result = reversedLines.toString();

		} catch (ParseException e) {
			e.printStackTrace();
		}
		logger.info("===== Processing request END : result : "  + result.getClass().getName() + " : '" + result + "'");
		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(TheTaskApplication.class, args);
	}
}

