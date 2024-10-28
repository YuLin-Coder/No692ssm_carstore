package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.SupplierDAO;
import com.entity.Supplier;
import com.service.SupplierService;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierDAO supplierDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertSupplier(Supplier supplier) {
		return this.supplierDAO.insertSupplier(supplier);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateSupplier(Supplier supplier) {
		return this.supplierDAO.updateSupplier(supplier);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteSupplier(String supplierid) {
		return this.supplierDAO.deleteSupplier(supplierid);
	}

	@Override // 继承接口的查询全部
	public List<Supplier> getAllSupplier() {
		return this.supplierDAO.getAllSupplier();
	}

	@Override // 继承接口的按条件精确查询
	public List<Supplier> getSupplierByCond(Supplier supplier) {
		return this.supplierDAO.getSupplierByCond(supplier);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Supplier> getSupplierByLike(Supplier supplier) {
		return this.supplierDAO.getSupplierByLike(supplier);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Supplier getSupplierById(String supplierid) {
		return this.supplierDAO.getSupplierById(supplierid);
	}

}


