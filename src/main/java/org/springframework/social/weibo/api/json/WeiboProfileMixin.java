/**
 * 
 */
package org.springframework.social.weibo.api.json;

import java.util.Date;

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
abstract class WeiboProfileMixin {

	@JsonCreator
	WeiboProfileMixin(
			@JsonProperty("id") long id,
			@JsonProperty("name") String name,
			@JsonProperty("screen_name") String screenName,
			@JsonProperty("profile_image_url") String imageUrl,
			@JsonProperty("domain") String domain,
			@JsonProperty("url") String url,
			@JsonProperty("province") int province,
			@JsonProperty("city") int city,
			@JsonProperty("location") String location,
			@JsonProperty("description") String description,
			@JsonProperty("gender") String gender,
			@JsonProperty("followers_count") int followersCount,
			@JsonProperty("friends_count") int friendsCount,
			@JsonProperty("statuses_count") int statusesCount,
			@JsonProperty("favourites_count") int favouritesCount,
			@JsonProperty("created_at") @JsonDeserialize(using = TimelineDateDeserializer.class) Date createdAt,
			@JsonProperty("following") boolean following,
			@JsonProperty("allow_all_act_msg") boolean allowAllActMsg,
			@JsonProperty("geo_enabled") boolean geoEnabled,
			@JsonProperty("verified") boolean verified,
			@JsonProperty("allow_all_comment") boolean allowAllComment,
			@JsonProperty("avatar_large") String avatarLarge,
			@JsonProperty("verified_reason") String verifiedReason,
			@JsonProperty("follow_me") boolean followMe,
			@JsonProperty("online_status") int onlineStatus,
			@JsonProperty("bi_followers_count") int biFollowersCount,
			@JsonProperty("status") Tweet status) {
	}

}
