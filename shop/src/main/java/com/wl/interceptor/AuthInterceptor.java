package com.wl.interceptor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wl.common.AuthWraper;
import com.wl.common.PathTest;
import com.wl.model.Resource;
import com.wl.model.User;

public class AuthInterceptor implements HandlerInterceptor {

	private static AuthWraper authData;
	static {
		// System.out.println(new PathTest().getClassesPath());
		Path path = Paths.get(new PathTest().getClassesPath(), "sqlconfig/auth.json");
		System.out.println(path.toString());
		File file = new File(path.toString());
		ObjectMapper mapper = new ObjectMapper();
		try {
			authData = mapper.readValue(file, AuthWraper.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// System.out.println(request.getSession().getServletContext().getRealPath("config/auth.json"));

		// System.out.println(new PathTest().getClassesPath() + "kk");
		// System.out.println("auth:" + request.getRequestURI());
		// return true;
		// System.out.println("getRequestURI:" + request.getRequestURI());
		// System.out.println("getContextPath:" + request.getContextPath());



		String s1 = request.getRequestURI();
		String s2 = request.getContextPath();
		String s3 = s1.substring(s2.length());
		System.out.println(s3);
		// System.out.println("getContextPath:" +
		// request.getSession().getServletContext().getContextPath());
		if (authData.getAllowUrl().contains(s3)) {
			return true;
		}
		if (authData.getForbidUrl().contains(s3)) {
			return false;
		}
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		String token = null;
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName()+":"+cookies[i].getValue());
			if (cookies[i].getName().equals("token")) {
				token = cookies[i].getValue();

			}
		}
		if (session.getAttribute("token") == null || token == null || !session.getAttribute("token").equals(token)) {
			response.sendRedirect(request.getContextPath() + "/static/view/login.html");
			return false;
		}

		session.setMaxInactiveInterval(60*30);
		User one = (User) session.getAttribute(token);
		Set<Resource> rs = one.getResources();
		Iterator<Resource> iter = rs.iterator();
		boolean hasUrl = false;
		while (iter.hasNext()) {
			Resource item = iter.next();
			if (item.getUrl().equals(s3)) {
				hasUrl = true;
				return true;
			}
		}
		response.sendRedirect(request.getContextPath() + "/static/view/forbid.html");
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
