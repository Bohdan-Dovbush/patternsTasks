package Collection.Helper;

public class MyCondition {

	private int condition;
	private Boolean action;
	private int[] conditions;
	
	public MyCondition() {}
	
	//constructor 1 = accepts one condition, and action - if true, many conditions exist, else only one condition
	public MyCondition(int condition, Boolean action) {
		this.condition = condition;
		this.action = action;
	}
	
	//constructor 2 = accepts two or many conditions, and action should be true
	public MyCondition(int[] conditions, Boolean action) {
		this.conditions = conditions;
		this.action = action;
	}
	
	//setters
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public void setAction(Boolean action) {
		this.action = action;
	}
	public void setConditions(int[] conditions) {
		this.conditions = conditions;
	}
	
	//getters
	public int getCondition() {
		return condition;
	}
	public Boolean getAction() {
		return action;
	}
	public int[] getConditions() {
		return conditions;
	}
}
