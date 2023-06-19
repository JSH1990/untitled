package com.kh.finalPjAm.Service;

import com.kh.finalPjAm.entity.Item;
import com.kh.finalPjAm.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ItemService {
    // 의존성 통해 빈에 등록된 필드는 불변성이 있어야 하므로 final 선언을 해야 함
    private final ItemRepository itemRepository;

    // 상품 저장
    public void saveItem(Item item) {
        itemRepository.save(item);
    }
}