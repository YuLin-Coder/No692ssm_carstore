package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.OutstorageDAO;
import com.entity.Outstorage;
import com.service.OutstorageService;

@Service("outstorageService")
public class OutstorageServiceImpl implements OutstorageService {
	@Autowired
	private OutstorageDAO outstorageDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertOutstorage(Outstorage outstorage) {
		return this.outstorageDAO.insertOutstorage(outstorage);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateOutstorage(Outstorage outstorage) {
		return this.outstorageDAO.updateOutstorage(outstorage);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteOutstorage(String outstorageid) {
		return this.outstorageDAO.deleteOutstorage(outstorageid);
	}

	@Override // 继承接口的查询全部
	public List<Outstorage> getAllOutstorage() {
		return this.outstorageDAO.getAllOutstorage();
	}

	@Override // 继承接口的按条件精确查询
	public List<Outstorage> getOutstorageByCond(Outstorage outstorage) {
		return this.outstorageDAO.getOutstorageByCond(outstorage);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Outstorage> getOutstorageByLike(Outstorage outstorage) {
		return this.outstorageDAO.getOutstorageByLike(outstorage);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Outstorage getOutstorageById(String outstorageid) {
		return this.outstorageDAO.getOutstorageById(outstorageid);
	}

}


