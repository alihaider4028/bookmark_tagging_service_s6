package com.anushka.bookmark_tagging_s6.Services.impl;

import com.anushka.bookmark_tagging_s6.Repository.EventRepository;
import com.anushka.bookmark_tagging_s6.Repository.TagRepository;
import com.anushka.bookmark_tagging_s6.Response.ApiResponse;
import com.anushka.bookmark_tagging_s6.Services.TagService;

import com.anushka.bookmark_tagging_s6.entity.Event;
import com.anushka.bookmark_tagging_s6.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImplementation implements TagService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    TagRepository tagRepository;

    @Override
    public ApiResponse<?> createTag(String tag, int eventId) {
        Event event = new Event();
        event = (this.eventRepository.findById(eventId).get());
        Tag tag1 = new Tag();
        tag1.setName(tag);
        this.tagRepository.save(tag1);

        event.getTags().add(tag1);
        this.eventRepository.save(event);
        Optional<String> resp = ("tag created").describeConstable();
        ApiResponse apiResponse = new ApiResponse<>(HttpStatus.CREATED.value(), "", resp);

        return apiResponse;
    }

    @Override
    public ApiResponse<?> updateTag(String tag, String updatedTag) {
        Tag tag1 = this.tagRepository.findByName(tag);
        tag1.setName(updatedTag);
        this.tagRepository.save(tag1);
        Optional<String> resp = ("tag updated").describeConstable();
        ApiResponse apiResponse = new ApiResponse<>(HttpStatus.CREATED.value(), "", resp);
        return apiResponse;

    }

    @Override
    public ApiResponse<?> deleteTag(int eventId, String tag) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            Tag tag1 = tagRepository.findByName(tag);

            if (event.getTags().contains(tag1)) {
                event.getTags().remove(tag1);
                eventRepository.save(event);
                tagRepository.delete(tag1);
            }
        }

        Optional<String> resp = ("tag deleted").describeConstable();
        ApiResponse apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "", resp);

        return apiResponse;

    }
}
