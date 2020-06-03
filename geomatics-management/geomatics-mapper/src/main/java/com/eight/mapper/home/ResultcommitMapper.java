package com.eight.mapper.home;

import com.eight.model.home.Resultcommit;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ResultcommitMapper extends Mapper<Resultcommit> {
     List<Resultcommit>  selectResultcommit();
}