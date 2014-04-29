/**
 * 
 */
package org.springframework.social.weibo.api;

import static org.junit.Assert.*;

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
public class WeiboProfileTestCase {
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
	 * Test method for {@link org.springframework.social.weibo.api.WeiboProfile#WeiboProfile(long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testWeiboProfile() {
		try {
			WeiboProfile profile = (WeiboProfile) converter.read(WeiboProfile.class, new HttpInputMessage() {
				
				@Override
				public HttpHeaders getHeaders() {
					return null;
				}
				
				@Override
				public InputStream getBody() throws IOException {
					return this.getClass().getResourceAsStream("/profile.json");
				}
			});
			assertEquals(1404376560L, profile.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
