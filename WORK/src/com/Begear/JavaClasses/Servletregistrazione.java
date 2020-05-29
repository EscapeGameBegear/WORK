package com.Begear.JavaClasses;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@WebServlet("/submit")
public class Servletregistrazione extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.sendRedirect(req.getContextPath() + "/");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessioneHttpSession = req.getSession();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sFactory = metadata.getSessionFactoryBuilder().build();
		
		String user = req.getParameter("username");
		String email = req.getParameter("email");
		String psw = req.getParameter("password");
		
		Pojo pj = new Pojo(user, email, psw);
		Session sessiondb = sFactory.openSession();
		sessiondb.beginTransaction();
		sessiondb.save(pj);
		sessiondb.getTransaction().commit();
	}
}
