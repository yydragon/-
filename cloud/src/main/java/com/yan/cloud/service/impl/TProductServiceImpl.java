package com.yan.cloud.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yan.cloud.entity.PageQuery;
import com.yan.cloud.entity.Query;
import com.yan.cloud.entity.TProduct;
import com.yan.cloud.mapper.TProductMapper;
import com.yan.cloud.service.TProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yan.cloud.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 用于定义产品 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@Service
public class TProductServiceImpl extends ServiceImpl<TProductMapper, TProduct> implements TProductService {

    @Override
    public IPage getProductList(Integer val) {
        Page<TProduct> page = new Page<>(val,8);
        IPage<TProduct> tProductIPage = baseMapper.selectPage(page, null);
        return tProductIPage;
    }

    @Override
    public void addProduct(TProduct product) {
        product.setProductNum(UUID.randomUUID().toString().substring(0,4));
        product.setIsDelete(0);
        baseMapper.insert(product);
    }

    @Override
    public void deleteProduct(String productNum) {
        baseMapper.delete(new QueryWrapper<TProduct>().eq("product_num",productNum));
    }

    @Override
    public void editProduct(TProduct product) {
        baseMapper.update(product,new QueryWrapper<TProduct>().eq("product_num",product.getProductNum()));
    }

    @Override
    public void deleteBatch(List<String> asList) {
        baseMapper.deleteBatchByIds(asList);
    }

    @Override
    public IPage getQueryList(Query query) {
        Page<TProduct> page = new Page<>(1,10);
        String name = query.getName();
        Integer flag = query.getFlag();
        QueryWrapper<TProduct> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(flag)){
            wrapper.like("product_name",name);
            wrapper.and(wrapper1->wrapper1.eq("flag",flag));
        }else{
            wrapper.like("product_name",name);
        }
        IPage<TProduct> iPage = baseMapper.selectPage(page, wrapper);
        return iPage;
    }

    @Override
    public IPage getSelectQuery(Integer val) {
        Page<TProduct> page = new Page<>(1,10);
        IPage<TProduct> iPage = baseMapper.selectPage(page, new QueryWrapper<TProduct>().eq("flag", val));
        return iPage;
    }


    @Override
    public IPage getAllProduct() {
        Page<TProduct> page = new Page<>(1,10);
        IPage<TProduct> tProductIPage = baseMapper.selectPage(page, null);
        return tProductIPage;
    }

    @Override
    public Map uploadFile(MultipartFile file) {
        String endpoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;

        try{
            //创建Oss实例
            OSS ossClient = new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
            String bucketName ="gulimall-m";
            //上传流文件
            InputStream inputStream = file.getInputStream();

            //调用oss方法实现上传
            //获取文件名称
            String filename = file.getOriginalFilename();
            //把文件名加上uuid
            String uuid = UUID.randomUUID().toString().replace("-","");
            filename = uuid+filename;
            //把文件按日期分类,使用工具类
            String datePath = new DateTime().toString("yyyy/MM/dd");
            //拼接
            filename = datePath+"/"+filename;
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("image/jpg");
            ossClient.putObject(bucketName,filename,inputStream);

            //关闭ossClient
            ossClient.shutdown();

            //把上传之后文件路径返回
            //需要把上传到阿里云oss路径手动返回
            String url = "https://"+bucketName+"."+endpoint+"/"+filename;
            HashMap<String, String> map = new HashMap<>();
            map.put("url",url);
            map.put("filename",filename);
            return map;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }




}
