package com.cg.fms.RepoImpl;

import java.util.HashSet;
import java.sql.*;

import com.cg.fms.RepoInterfaces.LanguageRepo;
import com.cg.fms.pojo.Film;
import com.cg.fms.pojo.Language;

public class LanguageRepoImpl implements LanguageRepo {
	static HashSet<Language> languages = new HashSet<Language>();
	ObjectMapper mapper = new ObjectMapper();
	ConnectionData connection = new ConnectionData();
	PreparedStatement st = null;
	Connection con=null;
	@Override
	public HashSet<Film> searchByLanguage(String language) throws Exception {
		// TODO Auto-generated method stub
		try{
			con = connection.ConnectionDataBase();
			st = con.prepareStatement("SELECT film_id,film.delete_update FROM film JOIN LANGUAGE USING(language_id) WHERE language.name = ? AND film.delete_update=0");
			st.setString(1, language);
			System.out.println("vamsi");
			ResultSet re = st.executeQuery();
			System.out.println(re);
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
