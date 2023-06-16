package com.anushka.bookmark_tagging_s6.Controller;

import com.anushka.bookmark_tagging_s6.Services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("tags")
public class TagController {
    @Autowired
    TagService tagService;

    @PostMapping(value = "createTag/{tag}/eventId/{eventId}", produces = "application/json")
    public ResponseEntity<?> createTag(@PathVariable("tag") String tag, @PathVariable("eventId") int eventId) {
        return ResponseEntity.ok(this.tagService.createTag(tag,eventId));
    }
    @DeleteMapping(value = "deleteTag/eventId/{eventId}/tag/{tag}", produces = "application/json")
    public ResponseEntity<?> deleteTag(@PathVariable("eventId") int eventId,@PathVariable("tag") String tag) {
        return ResponseEntity.ok(this.tagService.deleteTag(eventId,tag));
    }


    @PutMapping(value = "updateTag/Tag/{tag}/updatedTag/{updatedTag}", produces = "application/json")
    public ResponseEntity<?> updateTag(@PathVariable("tag") String tag,@PathVariable("updatedTag" )String updatedTag ) {
        return ResponseEntity.ok(this.tagService.updateTag(tag,updatedTag));
    }
}
