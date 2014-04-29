/**
 * 
 */
package org.springframework.social.weibo.api.json;

import java.util.Date;

import org.springframework.social.weibo.api.Geo;
import org.springframework.social.weibo.api.TimelineDateDeserializer;
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
abstract class TweetMixin {

	@JsonCreator
	public TweetMixin(
			@JsonProperty("created_at") @JsonDeserialize(using = TimelineDateDeserializer.class) Date createdAt,
			@JsonProperty("id") long id,
			@JsonProperty("text") String text,
			@JsonProperty("source") String source,
			@JsonProperty("favorited") boolean favorited,
			@JsonProperty("truncated") boolean truncated,
			@JsonProperty("in_reply_to_status_id") long inReplyToStatusId,
			@JsonProperty("in_reply_to_user_id") long inReplyToUserId,
			@JsonProperty("in_reply_to_screen_name") String inReplyToScreenName,
			@JsonProperty("user") WeiboProfile user,
			@JsonProperty("repostsCount") int repostsCount,
			@JsonProperty("commentsCount") int commentsCount) {
	}
	
	@JsonProperty("geo") private Geo geo;

}
