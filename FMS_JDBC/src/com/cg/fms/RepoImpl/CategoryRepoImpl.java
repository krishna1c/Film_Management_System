package com.cg.fms.RepoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;

import com.cg.fms.RepoInterfaces.CategoryRepo;
import com.cg.fms.pojo.Category;
import com.cg.fms.pojo.Film;

public class CategoryRepoImpl implements CategoryRepo {
	static HashSet<Category> categories = new HashSet<Category>();
	ObjectMapper mapper = new ObjectMapper();
	ConnectionData connection = new ConnectionData();
	PreparedStatement st = null;
	Connection con=null;
	@Override
	public HashSet<Film> searchByCategory(String category) throws Exception {
		// TODO Auto-generated method stub
		try{
			con = connection.ConnectionDataBase();
			st = con.prepareStatement("SELECT film_id FROM film JOIN category USING(category_id) WHERE category.name=? AND delete_update=0");
			st.setString(1, category);
			ResultSet re = st.executeQuery();
			
			return mapper.resultMapper(re,con);
		}
		catch(Exception e){
			throw new Exception();
		}
		finally{
			con.close();
		}
	}

}
