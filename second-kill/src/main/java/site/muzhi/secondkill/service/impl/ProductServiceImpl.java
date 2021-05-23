package site.muzhi.secondkill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.muzhi.secondkill.common.Product;
import site.muzhi.secondkill.mapper.ProductMapper;
import site.muzhi.secondkill.service.IProductService;

/**
 * @author lichuang
 * @date 2021/05/23
 * @description
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
}
