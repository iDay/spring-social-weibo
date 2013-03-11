/**
 * 
 */
package org.springframework.social.weibo.api.v2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.weibo.api.CommentOperations;
import org.springframework.social.weibo.api.TimelineOperations;
import org.springframework.social.weibo.api.UserOperations;
import org.springframework.social.weibo.api.Weibo;
import org.springframework.social.weibo.api.json.WeiboModule;
import org.springframework.social.weibo.connect.v2.WeiboRequestInterceptor;


/**
 * @author iday
 * 
 */
public class WeiboTemplate extends AbstractOAuth2ApiBinding implements Weibo {
	private UserOperations userOperations;
	private TimelineOperations timelineOperations;
	private CommentOperations commentOperations;
	private ObjectMapper objectMapper;

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
	public WeiboTemplate(String accessToken) {
		super(accessToken);
		List<ClientHttpRequestInterceptor> interceptors = new LinkedList<ClientHttpRequestInterceptor>();
		interceptors.add(new WeiboRequestInterceptor(accessToken));
		getRestTemplate().setInterceptors(interceptors);
		initialize();
	}

	private void initialize() {
		userOperations = new UserTemplate(this, getRestTemplate(),
				isAuthorized());
		timelineOperations = new TimelineTemplate(this, getRestTemplate(),
				isAuthorized());
		commentOperations = new CommentTemplate(this, getRestTemplate(),
				isAuthorized());
	}

	/**
	 * @return the userOperations
	 */
	@Override
	public UserOperations userOperations() {
		return userOperations;
	}

	/**
	 * @return the tweetOperations
	 */
	@Override
	public TimelineOperations timelineOperations() {
		return timelineOperations;
	}
	
	@Override
	public CommentOperations commentOperations() {
		return commentOperations;
	}

	@Override
	protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		MappingJacksonHttpMessageConverter converter = super
				.getJsonMessageConverter();
		List<MediaType> list = new ArrayList<MediaType>();
		list.addAll(converter.getSupportedMediaTypes());
		list.add(MediaType.TEXT_PLAIN);
		converter.setSupportedMediaTypes(list);

		objectMapper = new ObjectMapper();
		objectMapper.registerModule(new WeiboModule());
		converter.setObjectMapper(objectMapper);
		return converter;
	}

}
