package com.anushka.bookmark_tagging_s6.Repository;

import com.anushka.bookmark_tagging_s6.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Integer> {
    public Tag findByName(String tag);
}
