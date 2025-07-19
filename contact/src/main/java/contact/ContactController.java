package contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	ContactService service;
	
	public ContactController() {
		System.out.println("controller");
	}
	
//	http://localhost:8888/contacts/list?requestPage=1
	@RequestMapping("list")
	public ModelAndView list(@RequestParam(defaultValue = "1") int requestPage, ModelAndView mv) {
		mv.addObject("pageList", service.getPageList(requestPage));
		mv.setViewName("list");
		return mv;
	}
	
	@RequestMapping("view")
	public ModelAndView view(int id, ModelAndView mv) {
		mv.addObject("contact", service.getViewPage(id));
		mv.setViewName("view");
		return mv;
	}
	
	@RequestMapping("new")
	public String insert(Contact contact) {
		return "new";
	}
	
	@RequestMapping("save")
	public String save(Contact contact) {
		service.save(contact);
		return "redirect:/contacts/list";
	}
	
	@RequestMapping("edit")
	public ModelAndView edit(int id, ModelAndView mv) {
		mv.addObject("contact", service.getViewPage(id));
		mv.setViewName("edit");
		System.out.println(mv);
		return mv;
	}
	
	@RequestMapping("update")
	public String update(Contact contact) {
		service.update(contact);
		return "redirect:/contacts/list";
	}
	
	@RequestMapping("delete")
	public String delete(int id) {
		int result=service.delete(id);
		return "redirect:/contacts/list";
	}
}
