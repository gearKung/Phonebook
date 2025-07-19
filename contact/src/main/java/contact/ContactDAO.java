package contact;

import java.util.List;

public interface ContactDAO {
	public List<Contact> findAll(int startnum, int endnum);
	public Contact findById(int id);
	public int save(Contact contact);
	public int update(Contact contact);
	public int delete(int id);
	public int count();
	
}
