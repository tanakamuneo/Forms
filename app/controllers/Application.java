package controllers;

//デフォルトでimportされていたimport文
import play.*;
import play.mvc.*;
import views.html.*;

//自分でimportしたimport文
import play.data.Form;
import static play.data.Form.*;
import java.util.Date;
import models.MyForm;


//MVCモデルのうち、Cに対応するクラス
public class Application extends Controller {

	

	//メソッド1 初期値 ユーザ入力前
    public static Result index() {

    	//ジェネリクス
		Form<MyForm> myForm = form(MyForm.class).bindFromRequest();
			
			String topMessage = "フォームを入力してください。";

        		//初期値を変数fに格納する
        		MyForm f = new MyForm();
        		f.name = "default value";
        		f.check = true;
        		f.radio = "mac";
        		f.select = "uk";
        		f.inputNum = 50;

        		//fに格納された変数群をまとめてゼネリクスmyFormに格納する
        		myForm = myForm.fill(f);

        	//引数に入れた値を、index.scala.htmlでレンダリングする。
        	return ok(index.render(topMessage,myForm));
	
    }


    //メソッド2 入力値をページ上部に表示 ユーザ入力後
    public static Result send(){
    	Form<MyForm> myForm = form(MyForm.class).bindFromRequest();
    	if(!myForm.hasErrors()){
    		MyForm dataSet = myForm.get();

    			String value = "value : ";
    			value +=  "input =" + dataSet.name + ", ";
    			value +=  "pass = " + dataSet.password + ", ";
    			value +=  "check = " + dataSet.check + ", ";
    			value +=  "radio = " + dataSet.radio + ", ";
    			value +=  "select = " + dataSet.select + ", ";
    			value +=  "area = " + dataSet.textarea + ", ";
    			value +=  "date = " + dataSet.date + ", ";
    			value +=  "num = " + dataSet.inputNum + ", ";
  
    		return ok(index.render(value,myForm));
    	}else{
    		return ok(index.render("ERROR!!!", myForm));
    	}

    }

}






