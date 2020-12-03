package com.yan.cloud.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yan.cloud.entity.PageQuery;
import com.yan.cloud.entity.Query;
import com.yan.cloud.entity.TProduct;
import com.yan.cloud.service.TProductService;
import com.yan.cloud.utils.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用于定义产品 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@RestController
@RequestMapping("/product")
public class TProductController {

    @Resource
    private TProductService productService;


    @GetMapping("list")
    public R getProductList(@RequestParam("val") Integer val){
        IPage list = productService.getProductList(val);
        return R.ok().data("data",list);
    }

    @GetMapping("selectQuery")
    public R getSelectQuery(@RequestParam("val") Integer val){
        IPage list = productService.getSelectQuery(val);
        return R.ok().data("data",list);
    }

    @PostMapping("query")
    public R getQueryList(@RequestBody Query query){
        IPage list = productService.getQueryList(query);
        return R.ok().data("data",list);
    }

    @PostMapping("add")
    public R addProduct(@RequestBody TProduct product){
        productService.addProduct(product);
        return R.ok();
    }

    @GetMapping("delete")
    public R deleteProduct(@RequestParam(value="productNum") String productNum){
        System.out.println(productNum);
        productService.deleteProduct(productNum);
        return R.ok();
        }
    @RequestMapping("deleteBatch")
    public R deleteMul(@RequestBody String[] dels){
        productService.deleteBatch(Arrays.asList(dels));
        System.out.println(Arrays.asList(dels));

        return R.ok();
    }

    @PostMapping("edit")
    public R editProduct(@RequestBody TProduct product){
        productService.editProduct(product);
        return R.ok();
    }

    //上传图片的方法
    @PostMapping("upload")
    public R uploadOssFile(MultipartFile file){
        //返回上传到oss的路径
        Map<String,String> url = productService.uploadFile(file);

        return R.ok().data("url",url);
    }



}

