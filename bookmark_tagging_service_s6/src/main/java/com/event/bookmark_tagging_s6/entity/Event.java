package com.anushka.bookmark_tagging_s6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    private int capacity;
    private Date date;
    private String description;
    @ManyToOne
    private Location locationId;
    private int organizerId;

    @ManyToMany
    @JoinTable(
            name = "Event_tags",
            joinColumns = @JoinColumn(name = "Event", referencedColumnName = "eventId"),
            inverseJoinColumns = @JoinColumn(name = "Tag", referencedColumnName = "tagId")
    )    private List<Tag> tags;

    private String title;
    @ManyToOne
    private EventType typeId;

    // Constructors, getters, and setters
}
