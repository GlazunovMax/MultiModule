package by.htp.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import by.htp.entity.News;
import by.htp.entity.NewsForm;
import by.htp.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
//	Убирает пробелы
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}


	@GetMapping("/list")
	public String listNews(Model model) {
		List<News> theNews = newsService.getNews();
		
		NewsForm newsForm = new NewsForm();
		newsForm.setNewsList(theNews);
		
		model.addAttribute("newsFormList", newsForm);
		
		return "list-news";
	}
	
	
	@RequestMapping("/listStart")
	public String listNewsStart(){
		return "list-start";
	}


	@RequestMapping(value="/viewNews", method = RequestMethod.POST)
	public String viewNews(@RequestParam(value = "viewEdit", defaultValue = "null" ) long[] theId, Model model ){//
		
		List<News> theListNews = new ArrayList<News>();
		
		for (int i = 0; i < theId.length; i++) {	
			News theNews = newsService.fetchByIdNews(theId[i]);
			theListNews.add(theNews);
		}
		
		NewsForm newsForm = new NewsForm();
		newsForm.setNewsList(theListNews);
		
		model.addAttribute("newsForDelete", newsForm);
			
		return "view-news-list";
	}
	
//	ADD NEWS
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		News theNews = new News();
		
		NewsForm newsForm = new NewsForm();
		newsForm.setNewsMessage(theNews);
		
		theModel.addAttribute("newsForm", newsForm);
		
		return "news-form";
	}
	
	@PostMapping(value="/addNews") // action  в форме add
	public String addNews(@Valid @ModelAttribute("newsForm") NewsForm theNewsForm, BindingResult bindingResult, Model model) {
		System.out.println("Binding = " + bindingResult);
		
		if(bindingResult.hasErrors()){
			return "news-form";
		}
		
		News theNews = theNewsForm.getNewsMessage();
		newsService.saveNews(theNews);
		
		return "redirect:/news/list";
	}
	
	

	@RequestMapping("/deleteNews")
	public String removeNews(@RequestParam("id") long[] theId){
		
		for (int i = 0; i < theId.length; i++) {
			newsService.deleteNews(theId[i]);
		}
		
		return "redirect:/news/list";
	}

	
	
	
	@RequestMapping("/editNewsForm")
	public String listNews(@RequestParam("id") long theId, Model model){
		
		News news = new News();
		NewsForm newsForm = new NewsForm();
	
		news = newsService.fetchByIdNews(theId);
		newsForm.setNewsMessage(news);
		
		model.addAttribute("newsId", newsForm);
		
		return "edit-news-form";
	}
	
	@RequestMapping(value = "/updateNews", method = RequestMethod.POST )
		public String updateNews(@Valid @ModelAttribute("newsId") NewsForm theNewsForm, BindingResult bindingResult) {
		
			System.out.println("Binding = " + bindingResult);
			
			if(bindingResult.hasErrors()){
				return "edit-news-form";
			}
			
		News theNews = theNewsForm.getNewsMessage();
		newsService.updateNews(theNews);
		
		return "redirect:/news/list";
	}
	
}
