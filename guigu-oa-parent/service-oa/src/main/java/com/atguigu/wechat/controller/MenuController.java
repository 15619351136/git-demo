package com.atguigu.wechat.controller;


import com.atguigu.common.result.Result;
import com.atguigu.model.wechat.Menu;
import com.atguigu.vo.wechat.MenuVo;
import com.atguigu.wechat.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author 小户
 * @since 2023-05-04
 */
@RestController
@RequestMapping("/admin/wechat/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    //根据id查询
    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        Menu menu = menuService.getById(id);
        return Result.ok(menu);
    }
    
    //添加
    @ApiOperation(value = "添加")
    @PostMapping("save")
    public Result save(@RequestBody Menu menu){
        menuService.save(menu);
        return Result.ok();
    }

    //修改
    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result update(@RequestBody Menu menu){
        menuService.updateById(menu);
        return Result.ok();
    }

    //删除
    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        menuService.removeById(id);
        return Result.ok();
    }


    @ApiOperation(value = "删除菜单")
    @DeleteMapping("removeMenu")
    public Result removeMenu() {
        menuService.removeMenu();
        return Result.ok();
    }

    //获取全部菜单
    @ApiOperation(value = "获取全部菜单")
    @GetMapping("findMenuInfo")
    public Result findMenuInfo() {
        List<MenuVo> menuList=menuService.findMenuInfo();
        return Result.ok(menuList);
    }

    //同步菜单
    //@PreAuthorize("hasAuthority('bnt.menu.syncMenu')")
    @ApiOperation(value = "同步菜单")
    @GetMapping("syncMenu")
    public Result createMenu() {
        menuService.syncMenu();
        return Result.ok();
    }
}

