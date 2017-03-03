package com.daniele.hibernate.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.daniele.hibernate.dao.UserDetailsDao;
import com.daniele.hibernate.model.UserDetails;
import com.daniele.hibernate.model.UserDetails_;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
    
	@Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public UserDetails getUserById(long id) {
		TypedQuery<UserDetails> query = entityManager.createQuery("SELECT u "
				+ " FROM UserDetails u "
				+ " WHERE u.id = :id", UserDetails.class);
		query.setParameter("id", id);
		 return query.getSingleResult();
	}
	
	@Override
	public int countUsers() {
		String sql = "SELECT COUNT(*) "
				+ " FROM USER_DETAILS";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	@Override
	public List<UserDetails> getAllUsers(){
		 TypedQuery<UserDetails> query = entityManager.createQuery("SELECT u "
		 		+ "FROM UserDetails u", UserDetails.class);
		 return query.getResultList();
	}
	
	@Override
	public List<UserDetails> getUsersLike(String likeString){
		CriteriaBuilder builder =  entityManager.getCriteriaBuilder();
		CriteriaQuery<UserDetails> query = builder.createQuery(UserDetails.class);
		Root<UserDetails> root = query.from(UserDetails.class);
		query.where(builder.like(root.get(UserDetails_.name), likeString));
		return entityManager.createQuery(query).getResultList();	    
	}
	
	@Override
	public void saveUserDetails(UserDetails userDetails) {
		entityManager.persist(userDetails);
	}
}