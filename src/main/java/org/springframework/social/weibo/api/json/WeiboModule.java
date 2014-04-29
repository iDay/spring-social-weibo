/**
 * 
 */
package org.springframework.social.weibo.api.json;

import org.springframework.social.weibo.api.Comment;
import org.springframework.social.weibo.api.Geo;
import org.springframework.social.weibo.api.Tweet;
import org.springframework.social.weibo.api.WeiboProfile;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;



/**
 * @author iday
 *
 */
public class WeiboModule extends SimpleModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3348393373892814458L;

	public WeiboModule() {
		super("WeiboModule", new Version(1, 0, 0, null, null, null));
	}

	/* (non-Javadoc)
	 * @see org.codehaus.jackson.map.module.SimpleModule#setupModule(org.codehaus.jackson.map.Module.SetupContext)
	 */
	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(WeiboProfile.class, WeiboProfileMixin.class);
		context.setMixInAnnotations(Tweet.class, TweetMixin.class);
		context.setMixInAnnotations(Geo.class, GeoMixin.class);
		context.setMixInAnnotations(Comment.class, CommentMixin.class);
	}

}
