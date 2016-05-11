package models;

import java.util.Date;
import play.data.validation.Constraints.Required;


public class MyForm{

	//フォームに入力する値
	@Required(message = "This field is required")
	public String name;
	public String password;
	public boolean check;
	public String radio;
	public String select;
	public String textarea;
	public Date date;
	public int inputNum;

}