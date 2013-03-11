/**
 * 
 */
package com.couponornot.social.weibo.api.json;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;

import com.couponornot.social.weibo.api.Comment;
import com.couponornot.social.weibo.api.Geo;
import com.couponornot.social.weibo.api.Tweet;
import com.couponornot.social.weibo.api.WeiboProfile;


/**
 * @author iday
 *
 */
public class WeiboModule extends SimpleModule {

	public WeiboModule() {
		super("WeiboModule", new Version(1, 0, 0, null));
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
