package contact;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class OracleContactDAO implements ContactDAO {
	
	@Autowired
	DataSource ds;
	
	public OracleContactDAO() {
		System.out.println("dao");
	}
	
	@Override
	public List<Contact> findAll(int startnum, int endnum) {
		String sql = "select * from "
				+ "(select rownum rid, t1.* from "
				+ "(select * from contact order by id desc) t1 ) "
				+ "where rid>=? and rid<=?";
		
		
		try {
			PreparedStatement ps =ds.getConnection().prepareStatement(sql);
			ps.setInt(1, startnum);
			ps.setInt(2, endnum);
			ResultSet rs=ps.executeQuery();
			
			List<Contact> list = new ArrayList<Contact>();
			while(rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setPhonenumber(rs.getString("phonenumber"));
				contact.setEmail(rs.getString("email"));
//				contact.setAddress(rs.getString("address"));
//				contact.setMemo(rs.getString("memo"));
				list.add(contact);
			}
			rs.close();
			ps.close();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Contact findById(int id) {
		String sql ="select * from contact where id=?";
		try {
			PreparedStatement ps =ds.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Contact contact = new Contact();
			if(rs.next()) {
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setPhonenumber(rs.getString("phonenumber"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				contact.setMemo(rs.getString("memo"));
			}
			rs.close();
			ps.close();
			return contact;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int save(Contact contact) {
		String sql="insert into contact(id,name,phonenumber,email,address,memo) "
				+ "values (contact_seq.nextval, ?,?,?,?,?)";
		
		try {
			PreparedStatement ps = ds.getConnection().prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getPhonenumber());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getAddress());
			ps.setString(5, contact.getMemo());
			int result = ps.executeUpdate();
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int update(Contact contact) {
		String sql="update contact set name=?, phonenumber=?, email=?, address=?, memo=?"
				+  "where id=?";
		try {
			PreparedStatement ps =ds.getConnection().prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getPhonenumber());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getAddress());
			ps.setString(5, contact.getMemo()); 
			ps.setInt(6, contact.getId());
			int result =  ps.executeUpdate();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		String sql="delete from contact where id=?";
		try {
			PreparedStatement ps = ds.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			int result=ps.executeUpdate();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int count() {
		String sql="select count(*) count from contact";
		try {
			PreparedStatement ps = ds.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int totalCount = rs.getInt("count");
				rs.close();
				ps.close();
				return totalCount;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
}
