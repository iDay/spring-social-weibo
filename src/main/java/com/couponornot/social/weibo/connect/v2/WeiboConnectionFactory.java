/**
 * 
 */
package com.couponornot.social.weibo.connect.v2;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import com.couponornot.social.weibo.api.Weibo;
import com.couponornot.social.weibo.connect.WeiboAdapter;

/**
 * @author iday
 * 
 */
public class WeiboConnectionFactory extends OAuth2ConnectionFactory<Weibo> {

	public WeiboConnectionFactory(String clientId, String clientSecret) {
		super("weibo", new WeiboServiceProvider(clientId, clientSecret),
				new WeiboAdapter());
	}

}
