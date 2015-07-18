package com.org.jsf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		@Column(nullable=false)
		private String name;
		@Column(nullable=false, length=6)
		private String pass;
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((pass == null) ? 0 : pass.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (pass == null) {
				if (other.pass != null)
					return false;
			} else if (!pass.equals(other.pass))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", pass=" + pass + "]";
		}
		
		
}
