/**
 * 
 */
package org.springframework.social.weibo.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.weibo.api.json.WeiboModule;

/**
 * @author iday
 * 
 */
public class TweetTestCase {
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
	 * Test method for
	 * {@link org.springframework.social.weibo.api.Tweet#Tweet(java.util.Date, long, java.lang.String, java.lang.String, boolean, boolean, long, long, java.lang.String, org.springframework.social.weibo.api.WeiboProfile, int, int)}
	 * .
	 */
	@Test
	public void testTweet() {
		try {
			Tweet tweet = (Tweet) converter.read(Tweet.class,
					new HttpInputMessage() {

						@Override
						public HttpHeaders getHeaders() {
							return null;
						}

						@Override
						public InputStream getBody() throws IOException {
							return this.getClass().getResourceAsStream(
									"/tweet.json");
						}
					});
			assertEquals("求关注。", tweet.getText());
			assertEquals(1404376560, tweet.getUser().getId());
			assertNotNull(tweet.getGeo());
			assertEquals(116.39794, tweet.getGeo().getLongitude(), 0.000001);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
