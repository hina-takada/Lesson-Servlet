package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Employees;

public class EmployeesDAO extends DAO {

	public List<Employees> findAll() throws Exception {
		List<Employees> list = new ArrayList<Employees>();

		Connection con = getConnenction();

		PreparedStatement ps = con.prepareStatement("SELECT * FROM employees");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Employees e = new Employees();
			e.setId(rs.getInt("id"));
			e.setName(rs.getString("name"));
			e.setAge(rs.getInt("age"));
			list.add(e);
		}

		ps.close();
		con.close();

		return list;
	}

	public Employees findById(int id) throws Exception {
		Employees list = null;
		Connection con = getConnenction();

		PreparedStatement ps = con.prepareStatement("SELECT * FROM employees WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Employees e = new Employees();
			e.setId(rs.getInt("id"));
			e.setName(rs.getString("name"));
			e.setAge(rs.getInt("age"));
			list = e;
		}

		ps.close();
		con.close();

		return list;
	}

	public boolean insert(Employees employees) throws Exception {
		Connection con = getConnenction();

		
		PreparedStatement ps = con.prepareStatement("SELECT count(*) FROM employees WHERE name = ?");
		ps.setString(1, employees.getName());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next() && rs.getInt(1) > 0) {
			return false;
		}
		
		ps = con.prepareStatement("INSERT INTO employees(name,age)VALUES(?,?)");
		ps.setString(1, employees.getName());
		ps.setInt(2, employees.getAge());
		ps.executeUpdate();
		
		return true;
	}

	public boolean update(Employees employees) throws Exception {
		Connection con = getConnenction();

		PreparedStatement ps = con.prepareStatement("UPDATE employees set name = ?, age = ? WHERE id = ?");
		ps.setString(1, employees.getName());
		ps.setInt(2, employees.getAge());
		ps.setInt(3, employees.getId());
		int line = ps.executeUpdate();
		boolean check;
		
		if(line > 0) {
			check = true;
		}else {
			check = false;
		}
		
		return check;
	}

	public boolean delete(int id) throws Exception {
		Connection con = getConnenction();

		PreparedStatement ps = con.prepareStatement("DELETE FROM employees WHERE id = ?");
		ps.setInt(1, id);
		int line = ps.executeUpdate();
		boolean check;
		
		if(line > 0) {
			check = true;
		}else {
			check = false;
		}
		
		return check;
		
	}
}
