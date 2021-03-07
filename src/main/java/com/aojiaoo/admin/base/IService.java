package com.aojiaoo.admin.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface IService<E, M> {

    M getMapper();

    E get(Serializable id);

    E get(E e);

    /**
     * 保存 默认是带有Selective的保存 当字段为空时不做更新和插入
     *
     * @param entity entity
     * @return 是否保存成
     */
    @Transactional
    boolean save(E entity);

    @Transactional
    boolean update(E entity);

    @Transactional
    boolean insert(E entity);


    List<E> findList(E entity);


    IPage<E> findPage(IPage<E> page, E entity);


    boolean delete(Serializable id);
}
