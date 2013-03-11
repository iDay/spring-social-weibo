/**
 * 
 */
package org.springframework.social.weibo.connect.v1;

import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.weibo.api.Weibo;
import org.springframework.social.weibo.api.v1.WeiboTemplate;


/**
 * @author iday
 * 
 */
public class WeiboServiceProvider extends AbstractOAuth1ServiceProvider<Weibo> {

	public WeiboServiceProvider(String consumerKey, String consumerSecret) {
		super(consumerKey, consumerSecret, new WeiboOAuth1Template(consumerKey,
				consumerSecret, "http://api.t.sina.com.cn/oauth/request_token",
				"http://api.t.sina.com.cn/oauth/authorize",
				"http://api.t.sina.com.cn/oauth/access_token"));
	}

	@Override
	public Weibo getApi(String accessToken, String secret) {
		return new WeiboTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret);
	}

}
