package com.springboot.wooden.controller;

import com.springboot.wooden.domain.Item;
import com.springboot.wooden.dto.ItemRequestDto;
import com.springboot.wooden.dto.ItemResponseDto;
import com.springboot.wooden.repository.ItemRepository;
import com.springboot.wooden.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plan/itemlist")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;
    private final ItemRepository itemRepository;
    // 목록
    @GetMapping
    public List<ItemResponseDto> getAll() {
        return service.getAll();
    }

    // 전체 아이템 목록 (드롭다운용)
    @GetMapping("/main")
    public List<Item> getAllItems() {
        return itemRepository.findAllLight();
    }

    // 단건
    @GetMapping("/{itemNo}")
    public ItemResponseDto getOne(@PathVariable Long itemNo) {
        return service.getOne(itemNo);
    }

    // 등록
    @PostMapping
    public ResponseEntity<ItemResponseDto> create(@RequestBody @Valid ItemRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    // 수정
    @PutMapping("/{itemNo}")
    public ResponseEntity<ItemResponseDto> update(@PathVariable Long itemNo,
                                                  @RequestBody @Valid ItemRequestDto dto) {
        return ResponseEntity.ok(service.update(itemNo, dto));
    }

    // 삭제
    @DeleteMapping("/{itemNo}")
    public ResponseEntity<Void> delete(@PathVariable Long itemNo) {
        service.delete(itemNo);
        return ResponseEntity.noContent().build();
    }
}
