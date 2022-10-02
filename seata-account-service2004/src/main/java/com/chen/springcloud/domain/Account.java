package com.chen.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenchenchen
 * @create 2022-10-02 10:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
