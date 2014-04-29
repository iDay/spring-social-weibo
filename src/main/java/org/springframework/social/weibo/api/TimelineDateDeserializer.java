/**
 * 
 */
package org.springframework.social.weibo.api;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author iday
 *
 */
public class TimelineDateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
        try {
            return new SimpleDateFormat(TIMELINE_DATE_FORMAT, Locale.ENGLISH).parse(jp.getText());
        } catch (ParseException e) {
            return null;
        }
	}
	
	private static final String TIMELINE_DATE_FORMAT = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";

}
