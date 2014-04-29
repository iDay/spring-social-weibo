/**
 * 
 */
package org.springframework.social.weibo.api.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author iday
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class TagMixin {
	
	@JsonCreator
	public TagMixin(
			@JsonProperty("id") long id,
			@JsonProperty("tag") String tag,
			@JsonProperty("count") int count) {}

}
