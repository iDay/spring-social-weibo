/**
 * 
 */
package org.springframework.social.weibo.api;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.weibo.api.json.WeiboModule;
import org.springframework.social.weibo.api.v2.TweetList;


/**
 * @author iday
 *
 */
public class TweetListTestCase {
	MappingJackson2HttpMessageConverter converter;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new MappingJackson2HttpMessageConverter();

		converter.getObjectMapper().registerModule(new WeiboModule());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		converter = null;
	}

	/**
	 * Test method for {@link org.springframework.social.weibo.api.v2.TweetList#TweetList(java.util.List, long, long, long)}.
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
