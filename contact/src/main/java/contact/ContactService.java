package contact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ContactService {
	
	@Autowired
	ContactDAO dao;
	
	public ContactService() {
		System.out.println("service");
	}

	public Object getPageList(int requestPage) {
		try {
			PageList pageList = new PageList();
			pageList.setTotalCount(dao.count());
			pageList.setPagePerCount(10);
			int totalPage=0;
			if((pageList.getTotalCount()%pageList.getPagePerCount()) == 0) {
				totalPage = pageList.getTotalCount()/pageList.getPagePerCount();
			} else {
				totalPage = pageList.getTotalCount()/pageList.getPagePerCount() + 1;
			}
			pageList.setTotalPage(totalPage);

			pageList.setCurrentPage(requestPage);
			int startnum=((requestPage-1)*pageList.getPagePerCount()) + 1;
			int endnum=requestPage*pageList.getPagePerCount();

			int startPage = ((requestPage-1)/5 * 5) + 1;
			int endPage = startPage + 4;
			if(endPage>totalPage)
				endPage=totalPage;
			pageList.setStartPage(startPage);
			pageList.setEndPage(endPage);

			boolean isPre = requestPage>1;
			boolean isNext = requestPage<totalPage;
			
			pageList.setPre(isPre);
			pageList.setNext(isNext);
			
			List<Contact> contactList = dao.findAll(startnum, endnum);
				
			List<ContactList> contactLists = new ArrayList<ContactList>();
			for(Contact contact : contactList) { 
				ContactList contactlist=new ContactList(
						contact.getId(), 
						contact.getName(), 
						contact.getPhonenumber(), 
						contact.getEmail());
				contactLists.add(contactlist);
			}
			pageList.setList(contactLists);
			return pageList;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(Contact contact) {
		dao.save(contact);
	}

	public Contact getViewPage(int id) {
		Contact contact = dao.findById(id);
		return contact;
	}
	
	public void update(Contact contact) {
		dao.update(contact);
	}

	public int delete(int id) {
		return dao.delete(id);
	}

	

}
