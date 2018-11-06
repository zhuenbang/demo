package com.example.demo.common;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.QueryByExampleExecutor;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T,Long>,JpaSpecificationExecutor<T>,QueryByExampleExecutor<T> {

    /***
     * 分页数据
     * @param page 第几页，从1开始
     * @param size 一页显示数量，从20开始
     * @return
     */
    default PageRequest pageRequest(int page, int size){
        return pageRequest(page, size, null);
    }

    /***
     * 分页数据
     * @param page 第几页，从1开始
     * @param size 一页显示数量，从20开始
     * @return
     */
    default PageRequest pageRequest(int page, int size, Sort sort){
//       从第一页开始
        if(page<1) page = 1;
        if(size < 1) size = 20;
//       防止请求页数过大，整垮服务器
        if(size>100) size = 100;
        return new PageRequest(page-1, size,sort);
    }



    default PageResult<T> findAll(int page, int limit) {
        return findAll(page,limit,null);
    }

    default PageResult<T> findAll(int page, int limit, Sort sort) {
        Page<T> pageBean = findAll(pageRequest(page, limit, sort));
        PageResult PageResult = new PageResult(pageBean);
        return PageResult;
    }


    default PageResult<T> findAll(Specification<T> specifications, int page, int limit) {
        Page<T> pageBean = findAll(specifications, pageRequest(page, limit));
        PageResult PageResult = new PageResult(pageBean);
        return PageResult;
    }

    default PageResult<T> findAll(Example<T> var1, int page, int limit) {
        Page<T> pageBean = findAll(var1, pageRequest(page, limit));
        PageResult PageResult = new PageResult(pageBean);
        return PageResult;
    }



}
