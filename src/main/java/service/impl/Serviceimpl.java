package service.impl;

import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import entity.User;
import service.UserListService;
@Service("serviceimpl")  //�����ע��
@Transactional //���������
public class Serviceimpl implements UserListService{

	@Override
	public int Save(ArrayList<entity.User> u) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
