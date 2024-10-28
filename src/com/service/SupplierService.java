package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Supplier;

@Service("supplierService")
public interface SupplierService {
	// 插入数据 调用supplierDAO里的insertSupplier配置
	public int insertSupplier(Supplier supplier);

	// 更新数据 调用supplierDAO里的updateSupplier配置
	public int updateSupplier(Supplier supplier);

	// 删除数据 调用supplierDAO里的deleteSupplier配置
	public int deleteSupplier(String supplierid);

	// 查询全部数据 调用supplierDAO里的getAllSupplier配置
	public List<Supplier> getAllSupplier();

	// 按照Supplier类里面的字段名称精确查询 调用supplierDAO里的getSupplierByCond配置
	public List<Supplier> getSupplierByCond(Supplier supplier);

	// 按照Supplier类里面的字段名称模糊查询 调用supplierDAO里的getSupplierByLike配置
	public List<Supplier> getSupplierByLike(Supplier supplier);

	// 按主键查询表返回单一的Supplier实例 调用supplierDAO里的getSupplierById配置
	public Supplier getSupplierById(String supplierid);

}
