/**
 * 
 */
package org.springframework.social.weibo.connect.v2;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.weibo.api.Weibo;
import org.springframework.social.weibo.api.v2.WeiboTemplate;


/**
 * @author iday
 * 
 */
public class WeiboServiceProvider extends AbstractOAuth2ServiceProvider<Weibo> {

	public WeiboServiceProvider(String clientId, String clientSecret) {
		super(new WeiboOAuth2Template(clientId, clientSecret,
				"https://api.weibo.com/oauth2/authorize",
				"https://api.weibo.com/oauth2/access_token"));
	}

	@Override
	public Weibo getApi(String accessToken) {
		return new WeiboTemplate(accessToken);
	}

}
