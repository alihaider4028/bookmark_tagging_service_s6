package com.anushka.bookmark_tagging_s6.Services;

import com.anushka.bookmark_tagging_s6.Response.ApiResponse;

public interface TagService {
    public ApiResponse<?> createTag(String tag, int bookmarkId);
    public ApiResponse<?> updateTag(String tag,String updatedTag);
    public ApiResponse<?> deleteTag( int eventId, String tag);

}
