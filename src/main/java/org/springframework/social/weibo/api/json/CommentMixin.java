/**
 * 
 */
package org.springframework.social.weibo.api.json;

import java.util.Date;

import org.springframework.social.weibo.api.Comment;
import org.springframework.social.weibo.api.TimelineDateDeserializer;
import org.springframework.social.weibo.api.Tweet;
import org.springframework.social.weibo.api.WeiboProfile;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * @author iday
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CommentMixin {
	
	@JsonCreator
	public CommentMixin(
			@JsonProperty("id") long id,
			@JsonProperty("create_at") @JsonDeserialize(using = TimelineDateDeserializer.class) Date createAt,
			@JsonProperty("text") String text,
			@JsonProperty("source") String source,
			@JsonProperty("user") WeiboProfile user,
			@JsonProperty("status") Tweet status, 
			@JsonProperty("reply_comment") Comment replyComment) {}
}
