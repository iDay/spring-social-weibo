/**
 * 
 */
package com.couponornot.social.weibo.api;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import com.couponornot.social.weibo.api.json.WeiboModule;
import com.couponornot.social.weibo.api.v2.TweetList;

/**
 * @author iday
 *
 */
public class TweetListTestCase {
	MappingJacksonHttpMessageConverter converter;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new MappingJacksonHttpMessageConverter();
		
		ObjectMapper objectMapper = new ObjectMapper();				
		objectMapper.registerModule(new WeiboModule());
		converter.setObjectMapper(objectMapper);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		converter = null;
	}

	/**
	 * Test method for {@link com.couponornot.social.weibo.api.v2.TweetList#TweetList(java.util.List, long, long, long)}.
	 */
	@Test
	public void testTweetList() {
		try {
			TweetList list = (TweetList) converter.read(TweetList.class, new HttpInputMessage() {
				
				@Override
				public HttpHeaders getHeaders() {
					return null;
				}
				
				@Override
				public InputStream getBody() throws IOException {
					return this.getClass().getResourceAsStream("/tweetlist.json");
				}
			});
			assertEquals("求关注。", list.getStatuses().get(0).getText());
			assertEquals(1404376560, list.getStatuses().get(0).getUser().getId());
			assertEquals(11488013766L, list.getNextCursor());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
