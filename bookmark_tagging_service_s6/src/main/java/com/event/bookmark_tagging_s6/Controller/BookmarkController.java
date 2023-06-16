package com.anushka.bookmark_tagging_s6.Controller;

import com.anushka.bookmark_tagging_s6.Services.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("bookmark")
public class BookmarkController {
    @Autowired
    BookmarkService bookmarkService;




    @PostMapping(value = "addBookmark/{eventId}", produces = "application/json")
    public ResponseEntity<?> createBookmark(@PathVariable("eventId") int eventId) {
        return ResponseEntity.ok(this.bookmarkService.createBookmark(eventId));
    }

    @DeleteMapping(value = "deleteBookmark/{id}", produces = "application/json")
    public ResponseEntity<?> deleteBookmark(@PathVariable("id") int id) {
        return ResponseEntity.ok(this.bookmarkService.deleteBookmark(id));
    }

}
