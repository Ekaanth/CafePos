package com.squapl.sa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestSystemConfiguration implements SystemConfiguration{
	private String campaignimageuploadfolder = "z://Apache24//htdocs//img//campaign//";
	private String articleimagebaseuploadfolder =  "z://Apache24//htdocs//img//articles//";
	private String pictureimagebaseuploadfolder =  "z://Apache24//htdocs//img//pictures//";
	
	public String getCampaignImageBaseUploadFolder() {
		return this.campaignimageuploadfolder;
	}
	
	public String getArticleImageBaseUploadFolder() {
		return this.articleimagebaseuploadfolder;
	}

	public String getPictureImageBaseUploadFolder() {
		return this.pictureimagebaseuploadfolder;
	}

}
