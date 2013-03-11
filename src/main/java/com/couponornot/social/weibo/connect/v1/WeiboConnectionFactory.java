/**
 * 
 */
package com.couponornot.social.weibo.connect.v1;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;

import com.couponornot.social.weibo.api.Weibo;
import com.couponornot.social.weibo.connect.WeiboAdapter;

/**
 * @author iday
 * 
 */
public class WeiboConnectionFactory extends OAuth1ConnectionFactory<Weibo> {

	public WeiboConnectionFactory(String consumerKey, String consumerSecret) {
		super("weibo", new WeiboServiceProvider(consumerKey, consumerSecret),
				new WeiboAdapter());
	}

}
