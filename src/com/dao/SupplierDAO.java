package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Supplier;

@Repository("supplierDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface SupplierDAO {

	/**
	 * SupplierDAO 接口 可以按名称直接调用supplier.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包supplier.xml里的insertSupplier配置 返回值0(失败),1(成功)
	public int insertSupplier(Supplier supplier);

	// 更新数据 调用entity包supplier.xml里的updateSupplier配置 返回值0(失败),1(成功)
	public int updateSupplier(Supplier supplier);

	// 删除数据 调用entity包supplier.xml里的deleteSupplier配置 返回值0(失败),1(成功)
	public int deleteSupplier(String supplierid);

	// 查询全部数据 调用entity包supplier.xml里的getAllSupplier配置 返回List类型的数据
	public List<Supplier> getAllSupplier();

	// 按照Supplier类里面的值精确查询 调用entity包supplier.xml里的getSupplierByCond配置 返回List类型的数据
	public List<Supplier> getSupplierByCond(Supplier supplier);

	// 按照Supplier类里面的值模糊查询 调用entity包supplier.xml里的getSupplierByLike配置 返回List类型的数据
	public List<Supplier> getSupplierByLike(Supplier supplier);

	// 按主键查询表返回单一的Supplier实例 调用entity包supplier.xml里的getSupplierById配置
	public Supplier getSupplierById(String supplierid);

}
