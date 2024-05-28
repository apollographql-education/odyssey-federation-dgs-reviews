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
    ('Wow, what an experience! I"ve never stayed in a cave before, so I was a little unprepared. Luckily, this listing had all the amenities I needed to feel safe and prepared for anything.', 4, 'listing-1'),
    ('100% enjoyed the wilderness experience. Do not book if you are not an adventurer and lover of the outdoors.', 5, 'listing-1'),
    ('I thought this was going to be a cozy cave, but I was sorely disappointed. The mattress was hard, I could feel stones digging into my back. And it was COLD. They need to be more clear about this on the description.', 1, 'listing-1'),
    ('The COOLEST yurt I"ve ever been in!!! Check it out, you won"t regret it. The force shield is next level, we had a meteor shower come in the last night and besides a few rumbles, you couldn"t even tell!', 5, 'listing-2'),
    ('Meh, could be better honestly. I was expecting more. The lake was the only good part.', 2, 'listing-3'),
    ('Description was accurate. It was indeed a cave campsite in the snowy part of the planet. Exactly what I needed.', 5, 'listing-1'),
    ('I had a really long stay in Origae-6 for a work trip. The pod was small, but it had all I needed. Although I was starting to get space-crazy by the last week, I managed to survive.', 4, 'listing-8')