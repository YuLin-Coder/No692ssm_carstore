package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Instorage;

@Repository("instorageDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface InstorageDAO {

	/**
	 * InstorageDAO 接口 可以按名称直接调用instorage.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包instorage.xml里的insertInstorage配置 返回值0(失败),1(成功)
	public int insertInstorage(Instorage instorage);

	// 更新数据 调用entity包instorage.xml里的updateInstorage配置 返回值0(失败),1(成功)
	public int updateInstorage(Instorage instorage);

	// 删除数据 调用entity包instorage.xml里的deleteInstorage配置 返回值0(失败),1(成功)
	public int deleteInstorage(String instorageid);

	// 查询全部数据 调用entity包instorage.xml里的getAllInstorage配置 返回List类型的数据
	public List<Instorage> getAllInstorage();

	// 按照Instorage类里面的值精确查询 调用entity包instorage.xml里的getInstorageByCond配置 返回List类型的数据
	public List<Instorage> getInstorageByCond(Instorage instorage);

	// 按照Instorage类里面的值模糊查询 调用entity包instorage.xml里的getInstorageByLike配置 返回List类型的数据
	public List<Instorage> getInstorageByLike(Instorage instorage);

	// 按主键查询表返回单一的Instorage实例 调用entity包instorage.xml里的getInstorageById配置
	public Instorage getInstorageById(String instorageid);

}
