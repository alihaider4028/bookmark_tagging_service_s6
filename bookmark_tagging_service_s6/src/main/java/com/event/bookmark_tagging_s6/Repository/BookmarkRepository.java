package com.anushka.bookmark_tagging_s6.Repository;

import com.anushka.bookmark_tagging_s6.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark,Integer> {
}
