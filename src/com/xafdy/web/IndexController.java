package com.xafdy.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xafdy.entity.Admin;
import com.xafdy.entity.Comment;
import com.xafdy.entity.Foods;
import com.xafdy.entity.Item;
import com.xafdy.entity.User;
import com.xafdy.service.AdminService;
import com.xafdy.service.CommentService;
import com.xafdy.service.FoodsService;
import com.xafdy.service.ItemService;
import com.xafdy.service.UserService;


@Controller
public class IndexController {
	
	@Resource
	private ItemService itemService;
	
	@Resource
	private FoodsService foodsService;
	
	@Resource
	private AdminService adminService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private CommentService commentService;
        
	@RequestMapping("/logon")
	public ModelAndView logon() {
		ModelAndView  mav = new ModelAndView();
		mav.setViewName("logon");
		return mav;
	}
	
	@RequestMapping("/adminLogout")
	public ModelAndView adminLogout(HttpSession session) {
		ModelAndView  mav = new ModelAndView();
		session.setAttribute("admin", null);
		mav.setViewName("admin/logon");
		return mav;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView  mav = new ModelAndView();
		session.setAttribute("user", null);
		mav.setViewName("logon");
		return mav;
	}
	
	@RequestMapping("/adminLogon")
	public ModelAndView adminLogon(String account,String password,HttpSession session) {
		Admin admin = adminService.logon(account, password);
		if(admin != null) {
			session.setAttribute("admin", admin);
			return new ModelAndView("redirect:/adminIndex.html");
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("info", "用户名或密码错误");
			mav.setViewName("admin/logon");
			
			return mav;
		} 
	}
	
	@RequestMapping("/userLogon")
	public ModelAndView userLogon(String account, String password, HttpSession session) {
		User user = userService.logon(account, password);
		if(user != null) {
			session.setAttribute("user", user);
			return new ModelAndView("redirect:/index.html");
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("info", "<script>alert('用户名或密码错误');</script>");
			mav.setViewName("logon");
			
			return mav;
		} 
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register");
		return mav;
	}
	
	@RequestMapping("/saveUser")
	public ModelAndView saveUser(String account, String password, HttpSession session) {
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		userService.saveEntity(user);
		
		return new ModelAndView("redirect:/logon.html");
	}
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("items", itemService.getEntities(Item.class));
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/item/{id}")
	public ModelAndView item(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", itemService.getEntityById(Item.class, id));
		mav.addObject("foods", foodsService.getFoodsByItemId(id));
		mav.addObject("comments", commentService.getCommentByItem(id));
		mav.setViewName("item");
		return mav;
	}
	
	@RequestMapping("/searchForCity")
	public ModelAndView searchForCity() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchForCity");
		return mav;
	}
	
	@RequestMapping("/searchForItem")
	public ModelAndView searchForItem() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchForItem");
		return mav;
	}
	
	@RequestMapping("/getItemByCity")
	public ModelAndView getItemByCity(String city) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("items", itemService.getItemByCity(city));
		mav.setViewName("items");
		return mav;
	}
	
	@RequestMapping("/getItemByItem")
	public ModelAndView getItemByItem(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("items", itemService.getItemByName(name));
		mav.setViewName("items");
		return mav;
	}
	
	@RequestMapping("/items")
	public ModelAndView items() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("items");
		return mav;
	}
	
	@RequestMapping("/adminIndex")
	public ModelAndView adminIndex() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/index");
		
		return mav;
	}
	
	@RequestMapping("/createItem")
	public ModelAndView createItem() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/createItem");
		
		return mav;
	}
	
	@RequestMapping("/saveItem")
	public ModelAndView saveItem(Item item) {
		itemService.saveEntity(item);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/createItem");
		
		return mav;
	}
	
	@RequestMapping("/searchItem")
	public ModelAndView searchItem() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("items", itemService.getEntities(Item.class));
		mav.setViewName("admin/searchItem");
		
		return mav;
	}
	
	
	@RequestMapping("/updateItem/{id}")
	public ModelAndView updateItem(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", itemService.getEntityById(Item.class, id));
		mav.setViewName("admin/updateItem");
		
		return mav;
	}
	
	@RequestMapping("/editItem/{id}")
	public ModelAndView editItem(@PathVariable("id") Integer id, Item item) {
		Item model =  itemService.getEntityById(Item.class, id);
		model.setName(item.getName());
		model.setAddress(item.getAddress());
		model.setPrice(item.getPrice());
		model.setDays(item.getDays());
		model.setFeature(item.getFeature());
		model.setIntro(item.getIntro());
		model.setCity(item.getCity()); 
		
		itemService.updateEntity(model);
		
		return new ModelAndView("redirect:/searchItem.html"); 
	}
	
	@RequestMapping("/deleteItem/{id}")
	public ModelAndView deleteItem(@PathVariable("id") Integer id) {
		Item model =  itemService.getEntityById(Item.class, id);;
		
		itemService.deleteEntity(model);
		
		return new ModelAndView("redirect:/searchItem.html"); 
	}
	
	@RequestMapping("/createFood")
	public ModelAndView createFood() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("items", itemService.getEntities(Item.class));
		mav.setViewName("admin/createFood");
		
		return mav;
	}
	
	@RequestMapping("/saveFood")
	public ModelAndView saveFood(Foods foods) {
		foodsService.saveEntity(foods);
		
		return new ModelAndView("redirect:/createFood.html");
	}
	
	@RequestMapping("/searchFood")
	public ModelAndView searchFood() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("foods", foodsService.getEntities(Foods.class));
		mav.setViewName("admin/searchFoods");
		
		return mav;
	}
	
	
	@RequestMapping("/updateFood/{id}")
	public ModelAndView updateFood(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("items", itemService.getEntities(Item.class));
		mav.addObject("food", foodsService.getEntityById(Foods.class, id));
		mav.setViewName("admin/updateFoods");
		
		return mav; 
	}
	
	@RequestMapping("/editFood/{id}")
	public ModelAndView editFood(@PathVariable("id") Integer id, Foods foods) {
		Foods model =  foodsService.getEntityById(Foods.class, id);
		model.setName(foods.getName());
		model.setItem(foods.getItem());
		
		foodsService.updateEntity(model);
		
		return new ModelAndView("redirect:/searchFood.html"); 
	}
	
	@RequestMapping("/deleteFood/{id}")
	public ModelAndView deleteFood(@PathVariable("id") Integer id) {
		Foods model =  foodsService.getEntityById(Foods.class, id);;
		
		foodsService.deleteEntity(model);
		
		return new ModelAndView("redirect:/searchFood.html");
	}
	
	@RequestMapping("/saveFoodFile/{id}")
	public ModelAndView saveFoodFile(@RequestParam("file") MultipartFile multipartFile, HttpSession session, @PathVariable("id") Integer id, HttpServletRequest request) throws IllegalStateException, IOException {
		
		String fileName = System.currentTimeMillis()+getExtensionName(multipartFile.getOriginalFilename());
		String fileDir = request.getRealPath("/") + "images/" + fileName;
		System.out.println(fileDir);
		multipartFile.transferTo(new File(fileDir));
		
		Foods foods = foodsService.getEntityById(Foods.class, id);
		foods.setPath(fileName);
		foodsService.mergeEntity(foods);
		
		return new ModelAndView("redirect:/searchFood.html");
	}
	
	@RequestMapping("/saveItemFile/{id}")
	public ModelAndView saveItemFile(@RequestParam("file") MultipartFile multipartFile, HttpSession session, @PathVariable("id") Integer id, HttpServletRequest request) throws IllegalStateException, IOException {
		
		String fileName = System.currentTimeMillis()+getExtensionName(multipartFile.getOriginalFilename());
		String fileDir = request.getRealPath("/") + "images/" + fileName;
		System.out.println(fileDir);
		multipartFile.transferTo(new File(fileDir));
		
		Item item = itemService.getEntityById(Item.class, id);
		item.setPath(fileName);
		itemService.mergeEntity(item);
		
		return new ModelAndView("redirect:/searchItem.html");
	}
	
	private static String getExtensionName(String filename) {   
        if ((filename != null) && (filename.length() > 0)) {   
            int dot = filename.lastIndexOf('.');   
            if ((dot >-1) && (dot < (filename.length() - 1))) {   
                return "." + filename.substring(dot + 1);
            }   
        }   
        return "." + filename;   
    } 
	
	@RequestMapping("/saveComment/{id}")
	public ModelAndView saveComment(@PathVariable("id") Integer id, Comment comment, HttpSession session) {
		User user = (User) session.getAttribute("user"); 
		if (user == null) {
			return new ModelAndView("redirect:/logon.html");
		} else {
			comment.setUser(user);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			comment.setRecordTime(sdf.format(new Date()));
			comment.setItem(itemService.getEntityById(Item.class, id));
			
			commentService.saveEntity(comment);
			return new ModelAndView("redirect:/item/"+ id +".html");
		}
	}
	
}
