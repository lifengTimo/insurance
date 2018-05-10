package com.lifeng.insurance.model;


public class Tew extends DrugBodyLimit {

		//年龄限制名称
		private String bodyLimitName;

		public String getBodyLimitName() {
			return bodyLimitName;
		}

		public void setBodyLimitName(String bodyLimitName) {
			this.bodyLimitName = bodyLimitName;
		}

		@Override
		public String toString() {
			return super.toString()+ "Tew [bodyLimitName=" + bodyLimitName + "]";
		}
		
}
