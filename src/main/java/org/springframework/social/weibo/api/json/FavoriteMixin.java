/**
 * 
 */
package org.springframework.social.weibo.api.json;

import java.util.Date;
import java.util.List;

import org.springframework.social.weibo.api.Tag;
import org.springframework.social.weibo.api.TimelineDateDeserializer;
import org.springframework.social.weibo.api.Tweet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * @author iday
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class FavoriteMixin {
	
	@JsonCreator
	public FavoriteMixin(
			@JsonProperty("status") Tweet status,
			@JsonProperty("tags") List<Tag> tags,
			@JsonProperty("favorited_time") @JsonDeserialize(using = TimelineDateDeserializer.class) Date favoritedTime) {}

}
