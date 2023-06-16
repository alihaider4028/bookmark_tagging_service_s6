package com.anushka.bookmark_tagging_s6.Repository;

import com.anushka.bookmark_tagging_s6.entity.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType,Integer> {
}
