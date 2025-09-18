package com.pack.controller;

import java.util.ArrayList;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import com.pack.controller.*;
import com.pack.entity.Account;
//import com.google.gson.Gson;
import com.pack.entity.Info;
import com.pack.service.AccountService;
import com.pack.service.InfoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//import antlr.collections.List;
 
@Controller
@RequestMapping("/Records2")
public class InfoController 
{@Autowired
  InfoService infoService;
@Autowired
 AccountService accService;
	@RequestMapping(value="/",method=RequestMethod.GET)
  public String showMessage(){	
	System.out.println("in controllerrr");

	//ModelAndView mv = new ModelAndView("helloworld");
	//mv.addObject("message", message);
	//mv.addObject("name", name);
	return "index";
}
	@RequestMapping(value = { "/start"}, method = RequestMethod.GET)
	public String show2()
	{ //System.out.println("2asss "+session.getServletContext().getRealPath("/"));
		//return new ModelAndView("display.html");
	return "index";
	}

@RequestMapping(value="/info", method=RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE/*headers="Accept=application/json"*/)
//@ResponseBody
public ResponseEntity<Info> getInfo()
{ Info info= infoService.getInfo(1);
//Info info =new Info(2,"a","b");
//info.setId(2);
//info.setFname("a");
System.out.println("dd");
//info.setLname("b");
//Gson gs=new Gson();
//String str=gs.toJson(info);
//StringBuilder str= new StringBuilder();
 //str.append("fname "+info.getFname());
 //str.append("lname "+info.getLname());
  ArrayList<Info> list =new ArrayList<Info>();
   list.add(info);
	return new ResponseEntity<Info>(info,HttpStatus.OK);
}
@RequestMapping(value="create", method=RequestMethod.GET)
public String getHome()
{System.out.println("cr");
	return "createe";
}
@RequestMapping(value="/home", method=RequestMethod.POST/*headers="Accept=application/json"*/)
public String home(@RequestParam("name")String name ,@RequestParam(value="enter")String submit)
{ //System.out.println(name);
  System.out.println(submit);
  if(submit.equals("Create Account"))
   return "redirect:create";
	return "home";	
}
@RequestMapping(value="/createAcc", method=RequestMethod.POST)
public String createAcc(/*Account accJs,*/ Info inf,String email)
{  //System.out.println("aa "+accJs.getEmail());
	System.out.println("i "+inf.getFname()+" "+inf.getId());
	infoService.setInfo(inf);
	Account acc= new Account(email,inf.getPassword(),inf.getUsername());
	accService.setAcc(acc);
	//Account acc= accService.getAcc(accJs.getEmail());
   //if(acc==null)
	//return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
   //else
System.out.println("Em "+email);
   return "redirect:/Records2/";
	//return new ResponseEntity<Account>(acc,HttpStatus.ACCEPTED);
	
	
}
@RequestMapping(value="update", method=RequestMethod.POST)
public ResponseEntity<Info> change(@RequestBody Info infoJs)
{
	
	Info info=infoService.findUsername(infoJs.getUsername());
	if(info==null)
	{
		Account acc=accService.findUsername(infoJs.getUsername());
		if (acc!=null)
			infoService.setInfo(infoJs);
		
	}

	
	  if(info==null)
		return new ResponseEntity<Info>(HttpStatus.BAD_REQUEST);
	   else

		return new ResponseEntity<Info>(info,HttpStatus.ACCEPTED);
	
}




@RequestMapping(value="/getMail", method=RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Account> gMail(HttpSession sess)
{Account acc=(Account)sess.getAttribute("acc");
	//accService.
System.out.println("accc "+ acc.getEmail());
return new ResponseEntity<Account>(acc,HttpStatus.ACCEPTED);

}
 @RequestMapping(value="/getData", method=RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<Info> retreive(HttpSession sess)
 { 
	//Gson gson=new Gson();
//	gson.
	//System.out.println(infoStr+"    ooooo");
	Account acc= (Account)sess.getAttribute("acc");
//	Info info= new Info(1,"A","C","AACC");
	//System.out.println(acc.getEmail());
	Info info=infoService.findUsername(acc.getUsername());
	//System.out.println("getData");
	System.out.println(" gd "+info.getFname());
	

	  if(info==null)
		return new ResponseEntity<Info>(HttpStatus.NOT_FOUND);
	   else

	return new ResponseEntity<Info>(info,HttpStatus.ACCEPTED);
	
  }
 @RequestMapping(value="Sign", method=RequestMethod.GET)
 public String lpage()
 {System.out.println("ssin");
	 return "SignIn";
 }
 /*@RequestMapping(value="/checkCred", method=RequestMethod.GET)
 public String pretreive()
 {
	 return "redirect:/gCred";
 }*/
 @RequestMapping(value="/home", method=RequestMethod.GET)
 public String gretreive()
 {// return data;
	 //if(sess.getAttribute("acc")==null)
	 System.out.println("hh");
	 return "home";
 }
 @RequestMapping(value="/checkCred", method=RequestMethod.POST)/*,produces =MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)*/
 public String retreive(HttpSession sess, String name, String pwd)/*,@RequestBody Account accJs)*/
 { //  map.addAttribute("name",usr);
 //map.addAttribute("pwd",pwd);
 
	//Gson gson=new Gson();
//	gson.
	//System.out.println(infoStr+"    ooooo");
	 System.out.println(" dd "+name+" "+pwd);
	Account acc= accService.checkLogin(name, pwd);
	
	
 
	   if(acc==null)
		 return "redirect:/Records2/Sign";//new ResponseEntity<Account>(acc,HttpStatus.ACCEPTED);
	   else
	   { sess.setAttribute("acc", acc);
	   
	      
	     return "redirect:/Records2/home";//new ResponseEntity<Account>(acc,HttpStatus.ACCEPTED);
	   }
  }

 @RequestMapping(value="/modifyInfo", method=RequestMethod.POST)
 public ResponseEntity<Info> modify(HttpSession sess,@RequestBody Info info)
 { Account accSess=(Account)sess.getAttribute("acc");

    accSess.setUsername(info.getUsername());
    accSess.setPassword(info.getPassword());
	 accService.setAcc(accSess);
	
	
	 infoService.setInfo(info);
     System.out.println("id "+info.getId());
 System.out.println("inp "+info.getPassword());
     
	// Info ginfo=infoService.findUsername(info.getUsername());
	
	/* sess.setAttribute("acc", accService.getAcc(accSess.getEmail()));*/
	 System.out.println("inf "+info.getFname()+" "+info.getPassword());
	 return new ResponseEntity<Info>(info,HttpStatus.ACCEPTED);
	 
 }
 @RequestMapping(value="/logout", method=RequestMethod.POST)
 public String logout(HttpSession sess,HttpServletRequest request)
 {  //System.out.println(sess);
	 sess.removeAttribute("acc");
	 System.out.println("sess "+sess.getAttribute("acc"));
	 request.setAttribute("login", "false");
		sess.removeAttribute("acc");
		sess.invalidate();
		sess=null;
		ShopFilt.open=false;
	return "redirect:/Records2/";
 }
/* @RequestMapping(value="/checkCred#!/viewInfo", method=RequestMethod.GET)
 public String vindex()
 {
	 return "redirect:/";
 }*/
}
