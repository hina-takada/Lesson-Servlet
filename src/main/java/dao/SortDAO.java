package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Sort;

public class SortDAO extends DAO {
	
	public List<Sort> search(String keyword)throws Exception {
		List<Sort> list = new ArrayList<Sort>();
		Connection con = getConnenction();
		
		String sql = "SELECT * FROM product ORDER BY price ";
		if("higt".equals(keyword)) {
			sql += "DESC";
		}else if("low".equals(keyword)) {
			sql += "ASC";
		}
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Sort s = new Sort();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setPrice(rs.getInt("price"));
			list.add(s);
		}
		
		ps.close();
		con.close();
		
		return list;
	}
}
