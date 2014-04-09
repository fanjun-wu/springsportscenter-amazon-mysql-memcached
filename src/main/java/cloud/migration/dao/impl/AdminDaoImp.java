package cloud.migration.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cloud.migration.dao.AdminDao;
import cloud.migration.model.Admin;
import cloud.migration.service.AdminService;

@Repository
public class AdminDaoImp implements AdminDao {

	private SessionFactory session;

	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}

	@Override
	public void add(Admin admin) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(admin);
	}

	@Override
	public void edit(Admin admin) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(admin);
	}

	@Override
	public void delete(int adminId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getAdmin(adminId));
	}

	@Override
	public Admin getAdmin(int adminId) {
		// TODO Auto-generated method stub
		
		return (Admin)session.getCurrentSession().get(Admin.class, adminId);
	}

	@Override
	public List getAllAdmin() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Admin").list();
	}

	

}
