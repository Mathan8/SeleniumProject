package com.training.bean;

public class UserEnquiryBean {
		private String name;
		private String usermail;
		private String subject;
		private String message;

		public UserEnquiryBean() {
		}
		
		public  UserEnquiryBean(String name, String usermail, String subject, String message) {

			super();
			this.name = name;
			this.usermail = usermail;
			this.subject = subject;
			this.message = message;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getuserMail() {
			return usermail;
		}

		public void setuserMail(String usermail) {
			this.usermail = usermail;
		}
		
		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return "UserEnquiryBean [name=" + name + ", usermail=" + usermail + ", subject=" + subject +", message=" + message +"]";
		}

}
