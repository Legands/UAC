package com.shen.uac.vo;/*
 * @ClassName UserListVo
 * @Description TODO
 * @Author shaojunshen
 * @Date 2019/11/10 14:27
 * @Version 1.0
 * */

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserListVo {
    private String username;

    private String roleId;

    private Byte status;

    @NotNull
    @Min(1)
    private Integer pageNum;

    @NotNull
    @Min(0)
    private Integer pageSize;
}
