package com.springboot.wooden.service;

import com.springboot.wooden.dto.ItemStockRequestDto;
import com.springboot.wooden.dto.ItemStockResponseDto;

import java.util.List;

public interface ItemStockService {
    List<ItemStockResponseDto> getItemStocks();               // 목록
    ItemStockResponseDto getOne(Long isNo);                   // 단건
    void sell(Long itemNo, int qty);
    void produce(Long itemNo, int qty);
    void adjust(Long itemNo, int delta);
    ItemStockResponseDto adjust(ItemStockRequestDto request); // 수량 증감(±)
}
