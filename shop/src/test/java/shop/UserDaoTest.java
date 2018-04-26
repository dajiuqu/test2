package shop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wl.common.AuthWraper;
import com.wl.model.Resource;
import com.wl.model.ResourceDao;
import com.wl.model.Role;
import com.wl.model.RoleDao;
import com.wl.model.RoleResource;
import com.wl.model.RoleResourceDao;
import com.wl.model.SqlDao;
import com.wl.model.SqlWraper;
import com.wl.model.User;
import com.wl.model.UserDao;
import com.wl.model.UserRole;
import com.wl.model.UserRoleDao;

public class UserDaoTest {

	private static final int ArrayList = 0;

	// @Test
	public void userDaof1() {
		RoleDao mRoleDao = new RoleDao();
		ResourceDao mResourceDao = new ResourceDao();
		UserDao mUserDao = new UserDao();
		UserRoleDao mUserRoleDao = new UserRoleDao();
		RoleResourceDao mRoleResourceDao = new RoleResourceDao();
		User mUser = null;
		Role mRole = null;
		Resource mResource = null;
		UserRole mUserRole = null;
		RoleResource mRoleResource = null;
		//
		// for (int i = 0; i < 20; i++) {
		// mResource = new Resource();
		// mResource.setId("id" + i);
		// mResource.setUrl("url" + i);
		// mResourceDao.insert(mResource);
		// }
		//
		// for (int i = 0; i < 20; i++) {
		// mRole = new Role();
		// mRole.setId("id" + i);
		// mRole.setName("name" + i);
		// mRoleDao.insert(mRole);
		// }
		//
		// for (int i = 0; i < 20; i++) {
		// mUser = new User();
		// mUser.setId("id" + i);
		// mUser.setName("name" + i);
		// mUser.setPassword("password" + i);
		// mUserDao.insert(mUser);
		// }

		// for (int i = 0; i < 6; i++) {
		// mRoleResource = new RoleResource();
		// mRoleResource.setResourceId("id" + i);
		// mRoleResource.setRoleId("id1");
		// mRoleResourceDao.insert(mRoleResource);
		// }

		// for(int i=0;i<2;i++){
		// mUserRole=new UserRole();
		// mUserRole.setUserId("id1");
		// mUserRole.setRoleId("id"+i);
		// mUserRoleDao.insert(mUserRole);
		// }

		mUser = mUserDao.queryUserWithRoleAndResourceByUserId("id0");
		System.out.println(mUser);

	}

	public void resourceSave(Resource rs) {
		ResourceDao dao = new ResourceDao();
		dao.insert(rs);
		List<Resource> child = rs.getChildren();
		if (child != null) {
			Iterator<Resource> items = child.iterator();
			while (items.hasNext()) {
				Resource item = items.next();
				resourceSave(item);
			}
		}
	}

	// @Test
	public void fileTest() throws IOException {
		File file = new File("src/main/java/sqlconfig/init.json");
		try {
			ObjectMapper mapper = new ObjectMapper();
			List data = mapper.readValue(file, List.class);
			System.out.println(data.size());
			Iterator<LinkedHashMap> iter = data.iterator();
			while (iter.hasNext()) {
				LinkedHashMap item = iter.next();
				String res = mapper.writeValueAsString(item);
				Resource xxx = mapper.readValue(res, Resource.class);
				System.out.println(xxx);
				resourceSave(xxx);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public void clearSqlData() throws IOException {

		File sqlFile = new File("src/main/java/sqlconfig/initSql.sql");
		FileInputStream fs = new FileInputStream(sqlFile);
		int size = (int) sqlFile.length();
		byte[] buf = new byte[size];
		fs.read(buf);
		String str = new String(buf);
		SqlDao x = new SqlDao();
		SqlWraper sql = new SqlWraper(str);
		x.DoSql(sql);

	}

	@Test
	public void initSqlData() throws IOException {
		clearSqlData();
		UserDao user = new UserDao();
		User u = new User();
		u.setId("463178ba-5bdb-4220-85f5-f1fa859c9d61");
		u.setName("admin");
		u.setPassword("123456");
		u.setEnabled(1);
		user.insert(u);

		RoleDao roleDao = new RoleDao();
		Role r = new Role();
		r.setId("d3b69e56-72e2-4289-b3a4-eb0e952e60ef");
		r.setName("root");
		r.setDescription("³¬¼¶½ÇÉ«");
		r.setEnabled(1);
		// r.set
		roleDao.insert(r);
		UserRoleDao mUserRoleDao = new UserRoleDao();
		UserRole mUserRole = new UserRole();
		mUserRole.setUserId(u.getId());
		mUserRole.setRoleId(r.getId());
		mUserRoleDao.insert(mUserRole);

		File file = new File("src/main/java/sqlconfig/resource.json");

		ObjectMapper mapper = new ObjectMapper();
		List data = mapper.readValue(file, List.class);

		// System.out.println(data.size());
		Iterator<LinkedHashMap> iter = data.iterator();
		while (iter.hasNext()) {
			LinkedHashMap item = iter.next();
			String res = mapper.writeValueAsString(item);
			Resource xxx = mapper.readValue(res, Resource.class);
			// System.out.println(xxx);
			resourceSave(xxx);
		}
		ResourceDao mResourceDao = new ResourceDao();
		List<Resource> resources = mResourceDao.findAll();
		Iterator<Resource> iterss = resources.iterator();
		while (iterss.hasNext()) {
			Resource res = iterss.next();
			String resId = res.getId();
			RoleResource mRoleResource = new RoleResource();
			mRoleResource.setRoleId(r.getId());

			mRoleResource.setResourceId(resId);
			RoleResourceDao mRoleResourceDao = new RoleResourceDao();
			mRoleResourceDao.insert(mRoleResource);
		}
		// user.insert(item);

	}

	// @Test
	public void auth() throws JsonParseException, JsonMappingException, IOException {
		File file = new File("src/main/java/sqlconfig/auth.json");
		ObjectMapper mapper = new ObjectMapper();
		AuthWraper item = mapper.readValue(file, AuthWraper.class);
		System.out.println(item);
	}
}
