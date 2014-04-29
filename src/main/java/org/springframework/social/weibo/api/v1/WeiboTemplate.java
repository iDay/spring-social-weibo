/**
 * 
 */
package org.springframework.social.weibo.api.v1;

import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.weibo.api.CommentOperations;
import org.springframework.social.weibo.api.TimelineOperations;
import org.springframework.social.weibo.api.Weibo;
import org.springframework.social.weibo.api.json.WeiboModule;
import org.springframework.web.client.RestTemplate;


/**
 * @author iday
 * 
 */
public class WeiboTemplate extends AbstractOAuth1ApiBinding implements Weibo {
	private UserTemplate accountOperations;

	/**
	 * 
	 */
	public WeiboTemplate() {
		super();
		initialize();
	}

	/**
	 * @param consumerKey
	 * @param consumerSecret
	 * @param accessToken
	 * @param accessTokenSecret
	 */
	public WeiboTemplate(String consumerKey, String consumerSecret, String accessToken,
			String accessTokenSecret) {
		super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		initialize();
	}

	private void initialize() {
		registerRenrenJsonModule(getRestTemplate());
		accountOperations = new UserTemplate(this, getRestTemplate(),
				isAuthorized());
	}

	/**
	 * @return the userOperations
	 */
	public UserTemplate userOperations() {
		return accountOperations;
	}

	private void registerRenrenJsonModule(RestTemplate restTemplate) {
		List<HttpMessageConverter<?>> converters = getRestTemplate()
				.getMessageConverters();
		for (HttpMessageConverter<?> converter : converters) {
			if (converter instanceof MappingJackson2HttpMessageConverter) {
				MappingJackson2HttpMessageConverter jsonConverter = (MappingJackson2HttpMessageConverter) converter;
				jsonConverter.getObjectMapper().registerModule(new WeiboModule());
			}
		}
	}

	public TimelineOperations timelineOperations() {
		return null;
	}

	public CommentOperations commentOperations() {
		return null;
	}

}
