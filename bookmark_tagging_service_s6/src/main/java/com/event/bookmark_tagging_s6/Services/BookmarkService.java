package com.anushka.bookmark_tagging_s6.Services;


import com.anushka.bookmark_tagging_s6.Response.ApiResponse;

public interface BookmarkService {

    public ApiResponse<?> createBookmark(int eventId);
    public ApiResponse<?> deleteBookmark(int eventId);







}
