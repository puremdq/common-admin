package com.aojiaoo.admin.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BaseService<E extends BaseEntity<E>, M extends BaseMapper<E>> implements IService<E, M> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected M mapper;

    public M getMapper() {
        return mapper;
    }

    public E get(Serializable id) {
        return this.mapper.selectById(id);
    }

    @Override
    public E get(E e) {
        return this.mapper.selectOne(new QueryWrapper<>(e));
    }


    /**
     * 保存 默认是带有Selective的保存 当字段为空时不做更新和插入
     *
     * @param entity entity
     * @return 是否保存成
     */
    @Transactional
    public boolean save(E entity) {

        if (entity.getId() != null) {
            return this.update(entity);
        }
        //不存在id直接插入
        return this.insert(entity);
    }


    @Transactional
    public boolean update(E entity) {

        if (entity.getId() == null) {
            logger.warn("更新{}失败,传入的entity不包含主键,或者主键为空", entity);
            return false;
        }
        entity.setUpdateTime(new Date());
        return this.mapper.updateById(entity) > 0;
    }

    @Transactional
    public boolean insert(E entity) {
        entity.setUpdateTime(new Date());
        entity.setCreateTime(new Date());
        return this.mapper.insert(entity) > 0;
    }


    public List<E> findList(E entity) {
        return this.mapper.selectList(new QueryWrapper<>(entity));
    }


    public IPage<E> findPage(IPage<E> page, E entity) {
        return this.mapper.selectPage(page, new QueryWrapper<>(entity));
    }


    public boolean delete(Serializable id) {
        return this.mapper.deleteById(id) > 0;
    }
}
