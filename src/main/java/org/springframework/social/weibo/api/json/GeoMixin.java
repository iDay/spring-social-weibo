/**
 * 
 */
package org.springframework.social.weibo.api.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author iday
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class GeoMixin {
	
	@JsonCreator
	public GeoMixin(
			@JsonProperty("latitude") double latitude,
			@JsonProperty("longitude") double longitude) {}
	
	@JsonProperty("city") private int city;
	@JsonProperty("province") private int province;
	@JsonProperty("cityName") private String cityName;
	@JsonProperty("provinceName") private String provinceName;
	@JsonProperty("address") private String address;
	@JsonProperty("pinyin") private String pinyin;
	@JsonProperty("more") private String more;
}
