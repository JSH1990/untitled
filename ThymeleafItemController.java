package com.kh.finalPjAm.controller;

import com.kh.finalPjAm.Service.ItemService;
import com.kh.finalPjAm.dto.ItemDto;
import com.kh.finalPjAm.entity.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/thymeleaf")
public class ThymeleafItemController {
    private final ItemService itemService;

    @GetMapping("/items")
    public String getItemList(Model model) {
        List<ItemDto> itemDtoList = itemService.getItemList();
        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleaf/thymeleafItemList";
    }

    @GetMapping("/new")
    public String showItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "thymeleaf/item-form";
    }
    @PostMapping("/items")
    public String saveItem(Item item) {
        itemService.saveItem(item);
        return "thymeleaf/item-save";
    }
}