create table publisherContact(
publisherContactId int not null,
publisherContactStreet varchar(90),
publisherContactCity varchar(90),
publisherContactArea varchar(90),
publisherContactPhoneNo long,
primary key (publisherContactid)
);

create table publisher(
publisherId int not null,
publisherName varchar(90),
publisherContactid int not null,
primary key (publisherid),
foreign key (publisherContactId) references publisherContact(publisherContactId)
);

create table authorContact(
authorContactId int not null,
authorContactEmail varchar(90),
authorContactPhoneNo long,
authorContactStreet varchar(90),
authorContactArea varchar(90),
authorContactCity varchar(90),
primary key (authorContactId)
);

create table author(
authorId int not null,
authorName varchar(90),
authorContactId int not null,
primary key (authorId),
foreign key (authorContactId) references authorContact(authorContactId)
);

create table storeContact(
storeContactId int not null,
storeContactPhoneNo long,
storeContactStreet varchar(90),
storeContactArea varchar(90),
storeContactCity varchar(90),
primary key (storeContactId)
);

create table store(
storeId int not null,
storeName varchar(90),
storeContactId int not null,
primary key (storeId),
foreign key (storeContactId) references storeContact(storeContactId)
);

create table book(
bookId int not null,
bookName varchar(90),
bookPrice number(10,2),
bookPublisherId int,
bookImageFileName varchar(50),
primary key (bookId),
foreign key (bookPublisherId) references publisher(publisherId)
);

create table book_author(
bookId int not null,
authorId int not null,
primary key (bookId, authorId),
foreign key (bookId) references book(bookid),
foreign key (authorId) references author(authorId)
);

create table store_book(
storeId int not null,
bookId int not null,
primary key (bookId, storeId),
foreign key (bookId) references book(bookid),
foreign key (storeId) references store(storeId)
);