package com.anushka.bookmark_tagging_s6.Services.impl;

import com.anushka.bookmark_tagging_s6.Repository.BookmarkRepository;
import com.anushka.bookmark_tagging_s6.Repository.BookmarkTagRepository;
import com.anushka.bookmark_tagging_s6.Repository.EventRepository;
import com.anushka.bookmark_tagging_s6.Response.ApiResponse;
import com.anushka.bookmark_tagging_s6.Services.BookmarkService;
import com.anushka.bookmark_tagging_s6.entity.Bookmark;
import com.anushka.bookmark_tagging_s6.entity.BookmarkTag;
import com.anushka.bookmark_tagging_s6.entity.Event;
import com.anushka.bookmark_tagging_s6.entity.Tag;
import com.anushka.bookmark_tagging_s6.publisher.RabbitMQEventListProducer;
import com.anushka.bookmark_tagging_s6.publisher.RabbitMQEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookmarkServiceImpl implements BookmarkService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    RabbitMQEventListProducer rabbitMQEventListProducer;
    @Autowired

    RabbitMQEventProducer rabbitMQEventProducer;
    @Autowired
    BookmarkRepository bookmarkRepository;

    @Autowired
    BookmarkTagRepository bookmarkTagRepository;



    @Override
    public ApiResponse<?> createBookmark(int eventId) {
        Optional<String> resp = ("NO EVENT FOUND with This eventId "+eventId).describeConstable();
        ApiResponse<?> apiResponse;
        if (this.eventRepository.findById(eventId).isPresent()) {
            Bookmark bookmark = new Bookmark();
            bookmark.setEvent(this.eventRepository.findById(eventId).get());
            Bookmark savedBookmark =this.bookmarkRepository.save(bookmark);
            apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "Event Bookmarked", savedBookmark);
        } else {
            apiResponse = new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Event not found", resp);

        }
        return apiResponse;
    }


    @Override
    public ApiResponse<?> deleteBookmark(int Id) {
        Optional<String> resp = ("NO EVENT FOUND with This Id "+Id).describeConstable();
        ApiResponse<?> apiResponse;
        if (this.bookmarkRepository.findById(Id).isPresent()) {
            Bookmark bookmark = this.bookmarkRepository.findById(Id).get();
            this.bookmarkRepository.delete(bookmark);

            apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "Event deleted", bookmark);
        } else {
            apiResponse = new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Event not found", resp);

        }
        return apiResponse;
    }
}
