package com.example.demo.common;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("serial")
public class PageResult<T> extends GetResult<List<T>> {

    public PageResult() {
    }

    public PageResult(Page<T> page) {
        if (page != null) {
            setTotalPage(page.getTotalPages());
            setHasNext(page.hasNext());
            setTotal(page.getTotalElements());
            setCount(page.getNumberOfElements());
            setCurrPage(page.getNumber() + 1);
            setData(page.getContent());
        }
    }



    /****
     * 数据格式转换的时候使用
     * 里面的data 需要你自己转换
     * @param listResult
     */
    public PageResult(PageResult listResult) {
        if(listResult!=null){
            setCurrPage(listResult.getCurrPage());
            setTotal(listResult.getTotal());
            setTotalPage(listResult.getTotalPage());
            setCount(listResult.getCount());
            setHasNext(listResult.isHasNext());
        }
    }

    /******
     * 计算过结果转换
     * @param source
     * @param function 转换的方法
     * @param <R>   要转换的结果 （返给客户端的结果）
     * @param <M> 要被转换的参数类型 （数据库查询结果）
     * @return
     */
    public static <R, M> PageResult<R> result2Result(PageResult<M> source, Function<M, R> function) {
        PageResult<R> rtn = new PageResult<R>();
        if (source == null) {
            return rtn;
        }
        rtn = new PageResult<R>(source);
        List<R> collect = source.getData().stream().map(function).collect(Collectors.toList());
        rtn.setData(collect);
        return rtn;
    }

    /******
     * 计算过结果转换
     * @param source
     * @param function 转换的方法
     * @param <R>   要转换的结果 （返给客户端的结果）
     * @param <M> 要被转换的参数类型 （数据库查询结果）
     * @return
     */
    public static <R, M> PageResult<R> result2Result(Page<M> source, Function<M, R> function) {
        PageResult<R> rtn = new PageResult<R>();
        if (source == null) {
            return rtn;
        }
        rtn.setTotalPage(source.getTotalPages());
        rtn.setHasNext(source.hasNext());
        rtn.setTotal(source.getTotalElements());
        rtn.setCount(source.getNumberOfElements());
        rtn.setCurrPage(source.getNumber() + 1);
        List<R> collect = source.getContent().stream().map(function).collect(Collectors.toList());
        rtn.setData(collect);
        return rtn;
    }


    /******
     * 计算过结果转换
     * @param source
     * @param function 转换的方法
     * @param <R>   要转换的结果 （返给客户端的结果）
     * @param <M> 要被转换的参数类型 （数据库查询结果）
     * @return
     */
    public <R> PageResult<R> result2Result(Function<T, R> function) {
        PageResult<R> rtn = new PageResult<R>(this);
        List<R> collect = getData().stream().map(function).collect(Collectors.toList());
        rtn.setData(collect);
        return rtn;
    }

}