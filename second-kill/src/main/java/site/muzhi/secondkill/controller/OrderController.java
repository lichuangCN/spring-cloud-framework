package site.muzhi.secondkill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.muzhi.exception.BusinessRuntimeException;
import site.muzhi.result.Result;
import site.muzhi.result.ResultFactory;
import site.muzhi.secondkill.service.IOrderService;

/**
 * @author lichuang
 * @date 2021/05/23
 * @description
 */
@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/order")
    private Result order(@RequestParam Integer productId) throws BusinessRuntimeException {
        orderService.secondKill(productId);
        return ResultFactory.ok();
    }
}
