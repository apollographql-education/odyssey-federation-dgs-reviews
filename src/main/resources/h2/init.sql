create table reviews (
    id bigint auto_increment,
    text TEXT,
    rating float,
    listing varchar(255),
    primary key (id)
);

insert into reviews
    (text, rating, listing)
    values
    ('Wow, what an experience! Ive never stayed in a cave before, so I was a little unprepared. Luckily, this listing had all the amenities I needed to feel safe and prepared for anything.', 4, 'listing-1'),
    ('100% enjoyed the wilderness experience. Do not book if you are not an adventurer and lover of the outdoors.', 5, 'listing-2'),
    ('They were super accommodating! You should really fix the hole in the mesh entrance though, the flies were not friendly.', 4, 'listing-1')