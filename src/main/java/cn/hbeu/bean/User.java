
package cn.hbeu.bean;


public class User {
	private String name;
	private String sex;
	private int id;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", sex=" + sex + ", id=" + id + "]";
	}
	
	
	
}
