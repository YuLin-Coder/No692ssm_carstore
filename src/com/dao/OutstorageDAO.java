package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Outstorage;

@Repository("outstorageDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface OutstorageDAO {

	/**
	 * OutstorageDAO 接口 可以按名称直接调用outstorage.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包outstorage.xml里的insertOutstorage配置 返回值0(失败),1(成功)
	public int insertOutstorage(Outstorage outstorage);

	// 更新数据 调用entity包outstorage.xml里的updateOutstorage配置 返回值0(失败),1(成功)
	public int updateOutstorage(Outstorage outstorage);

	// 删除数据 调用entity包outstorage.xml里的deleteOutstorage配置 返回值0(失败),1(成功)
	public int deleteOutstorage(String outstorageid);

	// 查询全部数据 调用entity包outstorage.xml里的getAllOutstorage配置 返回List类型的数据
	public List<Outstorage> getAllOutstorage();

	// 按照Outstorage类里面的值精确查询 调用entity包outstorage.xml里的getOutstorageByCond配置
	// 返回List类型的数据
	public List<Outstorage> getOutstorageByCond(Outstorage outstorage);

	// 按照Outstorage类里面的值模糊查询 调用entity包outstorage.xml里的getOutstorageByLike配置
	// 返回List类型的数据
	public List<Outstorage> getOutstorageByLike(Outstorage outstorage);

	// 按主键查询表返回单一的Outstorage实例 调用entity包outstorage.xml里的getOutstorageById配置
	public Outstorage getOutstorageById(String outstorageid);

}
