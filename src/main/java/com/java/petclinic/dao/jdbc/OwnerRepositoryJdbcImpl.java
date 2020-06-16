//package com.java.petclinic.dao.jdbc;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.support.DataAccessUtils;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import com.java.petclinic.model.Owner;
//import com.java.petclinic.service.PetClinicService;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import com.java.petclinic.dao.OwnerRepository;
//
//@Repository
//public class OwnerRepositoryJdbcImpl implements OwnerRepository{
//
//	@Autowired 
//	private JdbcTemplate jdbcTemplate;
//	
//	private RowMapper<Owner> rowMapper = new RowMapper<Owner>() {
//		
//		@Override
//		public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
//			Owner owner = new Owner();
//			owner.setId(rs.getLong("id"));
//			owner.setFirstName(rs.getString("first_name"));
//			owner.setLastName(rs.getString("last_name"));
//			return owner;
//		}
//	};
//	
//	public List<Owner> findAll(){
//		String sql = "SELECT id,first_name,last_name from t_owner";
//		return jdbcTemplate.query(sql, rowMapper);
//	}
//	
//	public Owner findById(Long id) {
//		String sql = "SELECT id, first_name,last_name from t_owner where id = ?";
//		return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper, id));
//	}
//	
//	public List<Owner> findByLastName(String lastName){
//		String sql = "SELECT id, first_name, last_name from t_owner where last_name like ?";
//		return jdbcTemplate.query(sql, rowMapper, "%", lastName + "%");
//	}
//	
//	public void create(Owner owner) {
//		
//	}
//	
//	public Owner update(Owner owner) {
//		return null;
//	}
//	
//	public void delete(Long id) {
//		String sql = "delete from t_owner where id = ?";
//		jdbcTemplate.update(sql, id);
//	}
//}
