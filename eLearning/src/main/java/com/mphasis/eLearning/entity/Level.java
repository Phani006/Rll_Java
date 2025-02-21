package com.mphasis.eLearning.entity;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Level {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int levelId;
	
	private String levelName;
	@ManyToOne
	@JsonIgnore
	private Course courseRef;

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Course getCourseRef() {
		return courseRef;
	}

	public void setCourseRef(Course courseRef) {
		this.courseRef = courseRef;
	}

	public Level(int levelId, String levelName, Course courseRef) {
		super();
		this.levelId = levelId;
		this.levelName = levelName;
		this.courseRef = courseRef;
	}

	public Level() {
		super();
	}

	@Override
	public String toString() {
		return "Level [levelId=" + levelId + ", levelName=" + levelName + ", courseRef=" + courseRef + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseRef, levelId, levelName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Level other = (Level) obj;
		return Objects.equals(courseRef, other.courseRef) && levelId == other.levelId
				&& Objects.equals(levelName, other.levelName);
	}
	
	
}
