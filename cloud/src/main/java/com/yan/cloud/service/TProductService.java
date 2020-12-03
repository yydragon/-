package com.yan.cloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yan.cloud.entity.PageQuery;
import com.yan.cloud.entity.Query;
import com.yan.cloud.entity.TProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用于定义产品 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
public interface TProductService extends IService<TProduct> {

    IPage getProductList(Integer val);

    void addProduct(TProduct product);

    void deleteProduct(String productNum);

    void editProduct(TProduct product);

    void deleteBatch(List<String> asList);

    IPage getQueryList(Query query);

    IPage getSelectQuery(Integer val);



    IPage getAllProduct();

    Map uploadFile(MultipartFile file);



}
