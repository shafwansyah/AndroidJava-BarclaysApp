package com.example.barclaysapp.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response implements Serializable {

	@SerializedName("teams")
	private List<TeamsItem> teams;

	public List<TeamsItem> getTeams(){
		return teams;
	}
}