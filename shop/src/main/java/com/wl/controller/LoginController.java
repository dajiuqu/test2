package com.wl.controller;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wl.common.ResultInfo;
import com.wl.model.User;
import com.wl.model.UserDao;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	@PostMapping("in")
	public ResultInfo<String> loginIn(@RequestBody String body) {
		ObjectMapper mapper = new ObjectMapper();
		ResultInfo<String> rs = new ResultInfo<String>();
		try {
			Map<String, String> map = mapper.readValue(body, Map.class);

			String name = map.get("name");
			String password = map.get("password");
			UserDao mUserDao = new UserDao();
			User mUser = mUserDao.queryUserWithRoleAndResource(name, password);
			if (mUser != null) {
				HttpSession session = this.request.getSession();
				UUID uid = UUID.randomUUID();
				String token = uid.toString();
				session.setAttribute("token", token);
				session.setAttribute(token, mUser);
				session.setMaxInactiveInterval(60 * 30);
				Cookie ck = new Cookie("token", token);
				ck.setMaxAge(30 * 60);
				ck.setPath("/");
				this.response.addCookie(ck);
				rs.setSuc(true);
			}

			// rs.setData(name + ":" + password);
			// return "{'wl':123,'ee':888}";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rs.setSuc(false);
			rs.setException(e.toString());
		}

		return rs;
	}

	@GetMapping("out")
	public ResultInfo<String> logout() {
		ResultInfo<String> rs = new ResultInfo<String>();
		rs.setSuc(true);
		HttpSession session = this.request.getSession();
		// session.getAttribute("token");
		// session.removeAttribute("token");
		this.request.getSession().invalidate();

		return rs;

	}

}
