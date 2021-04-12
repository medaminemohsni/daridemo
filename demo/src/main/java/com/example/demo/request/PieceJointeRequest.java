package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PieceJointeRequest {

	String attachementName;

	String attachementData;

	public String getAttachementName() {
		return attachementName;
	}

	public void setAttachementName(String attachementName) {
		this.attachementName = attachementName;
	}

	public String getAttachementData() {
		return attachementData;
	}

	public void setAttachementData(String attachementData) {
		this.attachementData = attachementData;
	}
	
	
}
