/**
 * 
 */
package com.couponornot.social.weibo.api;

import org.springframework.social.ApiBinding;

import com.couponornot.social.weibo.api.UserOperations;

/**
 * @author iday
 *
 */
public interface Weibo extends ApiBinding {

	public abstract UserOperations userOperations();

	public abstract TimelineOperations timelineOperations();

	public abstract CommentOperations commentOperations();
	
}
