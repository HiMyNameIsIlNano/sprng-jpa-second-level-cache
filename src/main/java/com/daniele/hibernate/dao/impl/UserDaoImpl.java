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

import com.daniele.hibernate.dao.UserDao;
import com.daniele.hibernate.model.UserAccount;
import com.daniele.hibernate.model.UserAccount_;

@Repository
public class UserDaoImpl implements UserDao {
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
	public UserAccount getUserById(long id) {
		TypedQuery<UserAccount> query = entityManager.createQuery("SELECT u "
				+ " FROM UserAccount u "
				+ " WHERE u.id = :id", UserAccount.class);
		query.setParameter("id", id);
		 return query.getSingleResult();
	}
	
	@Override
	public int countUsers() {
		String sql = "SELECT COUNT(*) "
				+ " FROM USER_ACCOUNT";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	@Override
	public List<UserAccount> getAllUsers(){
		 TypedQuery<UserAccount> query = entityManager.createQuery("SELECT u "
		 		+ "FROM UserAccount u", UserAccount.class);
		 return query.getResultList();
	}
	
	@Override
	public List<UserAccount> getUsersLike(String likeString){
		CriteriaBuilder builder =  entityManager.getCriteriaBuilder();
		CriteriaQuery<UserAccount> query = builder.createQuery(UserAccount.class);
		Root<UserAccount> root = query.from(UserAccount.class);
		query.where(builder.like(root.get(UserAccount_.name), likeString));
		return entityManager.createQuery(query).getResultList();
	}
	
	@Override
	public void saveUser(UserAccount user) {
		entityManager.persist(user);
	}
}