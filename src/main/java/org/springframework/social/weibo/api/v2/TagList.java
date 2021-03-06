/**
 * 
 */
package org.springframework.social.weibo.api.v2;

import java.io.Serializable;
import java.util.List;

import org.springframework.social.weibo.api.Tag;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author iday
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2878220694560586729L;
	private final List<Tag> tags;
	private final long totalNumber;
	
	/**
	 * @param tags
	 * @param totalNumber
	 */
	@JsonCreator
	public TagList(
			@JsonProperty("tags") List<Tag> tags,
			@JsonProperty("total_number") long totalNumber) {
		this.tags = tags;
		this.totalNumber = totalNumber;
	}

	/**
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * @return the totalNumber
	 */
	public long getTotalNumber() {
		return totalNumber;
	}

}
