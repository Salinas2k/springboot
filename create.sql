create table activities (id  bigserial not null, date timestamp, description varchar(255), name varchar(255), primary key (id))
create table activities_contact_collection (activities_id int8 not null, contact_collection_id int8 not null)
create table activities_customer_collection (activities_id int8 not null, customer_collection_id int8 not null)
create table contact (id  bigserial not null, address varchar(255), company varchar(255), date_birth date, email varchar(255), name varchar(255), phone varchar(255), profession varchar(255), surname varchar(255), volunteer boolean, customer_id int8, primary key (id))
create table contact_activities_collection (contact_id int8 not null, activities_collection_id int8 not null)
create table customer (id  bigserial not null, address varchar(255), company varchar(255), date_birth date, email varchar(255), name varchar(255), phone varchar(255), profession varchar(255), surname varchar(255), volunteer boolean, primary key (id))
create table customer_activities_collection (customer_id int8 not null, activities_collection_id int8 not null)
create table medical_data (id  bigserial not null, debut_date timestamp, diabetes_type varchar(255), handicap boolean, patology varchar(255), customer_id int8, primary key (id))
create table roles (role_id  bigserial not null, name varchar(255), primary key (role_id))
create table subscription (id  bigserial not null, account varchar(255), adirmu_enddate date, adirmu_startdate date, adirmu_status boolean, cash boolean, payment_day date, periodity varchar(255), reason varchar(255), customer_id int8, primary key (id))
create table users (username varchar(255) not null, enabled boolean, password varchar(255), primary key (username))
create table users_roles (user_id varchar(255) not null, role_id int8 not null, primary key (user_id, role_id))
alter table activities_contact_collection add constraint FK5npc6t2nesrdd9q3q2d2gq2f2 foreign key (contact_collection_id) references contact
alter table activities_contact_collection add constraint FK3my12cy2fej30oyiyk4q208mh foreign key (activities_id) references activities
alter table activities_customer_collection add constraint FK77d2e734hjmlbqo7sh2x9kgj4 foreign key (customer_collection_id) references customer
alter table activities_customer_collection add constraint FKfkxx921e9a2niubslwg2iv0ej foreign key (activities_id) references activities
alter table contact add constraint FKckoarj5a5jmet3b3smgdhaopw foreign key (customer_id) references customer
alter table contact_activities_collection add constraint FK263g0m1qfqvnchdrmf0ni1jx6 foreign key (activities_collection_id) references activities
alter table contact_activities_collection add constraint FK6dqnj43w532hblpv7ckeakwdk foreign key (contact_id) references contact
alter table customer_activities_collection add constraint FKay1i8rhgb8f9hwe1fte45ampe foreign key (activities_collection_id) references activities
alter table customer_activities_collection add constraint FK62j21fri6in7dcewbg0e1suhd foreign key (customer_id) references customer
alter table medical_data add constraint FKmf6rcdttxdhe3ohwlqci1euti foreign key (customer_id) references customer
alter table subscription add constraint FKg04cmtkq431k68csu8emybpcc foreign key (customer_id) references customer
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users
create table activities (id  bigserial not null, date timestamp, description varchar(255), name varchar(255), primary key (id))
create table activities_contact_collection (activities_id int8 not null, contact_collection_id int8 not null)
create table activities_customer_collection (activities_id int8 not null, customer_collection_id int8 not null)
create table contact (id  bigserial not null, address varchar(255), company varchar(255), date_birth date, email varchar(255), name varchar(255), phone varchar(255), profession varchar(255), surname varchar(255), volunteer boolean, customer_id int8, primary key (id))
create table contact_activities_collection (contact_id int8 not null, activities_collection_id int8 not null)
create table customer (id  bigserial not null, address varchar(255), company varchar(255), date_birth date, email varchar(255), name varchar(255), phone varchar(255), profession varchar(255), surname varchar(255), volunteer boolean, primary key (id))
create table customer_activities_collection (customer_id int8 not null, activities_collection_id int8 not null)
create table medical_data (id  bigserial not null, debut_date timestamp, diabetes_type varchar(255), handicap boolean, patology varchar(255), customer_id int8, primary key (id))
create table roles (role_id  bigserial not null, name varchar(255), primary key (role_id))
create table subscription (id  bigserial not null, account varchar(255), adirmu_enddate date, adirmu_startdate date, adirmu_status boolean, cash boolean, payment_day date, periodity varchar(255), reason varchar(255), customer_id int8, primary key (id))
create table users (username varchar(255) not null, enabled boolean, password varchar(255), primary key (username))
create table users_roles (user_id varchar(255) not null, role_id int8 not null, primary key (user_id, role_id))
alter table activities_contact_collection add constraint FK5npc6t2nesrdd9q3q2d2gq2f2 foreign key (contact_collection_id) references contact
alter table activities_contact_collection add constraint FK3my12cy2fej30oyiyk4q208mh foreign key (activities_id) references activities
alter table activities_customer_collection add constraint FK77d2e734hjmlbqo7sh2x9kgj4 foreign key (customer_collection_id) references customer
alter table activities_customer_collection add constraint FKfkxx921e9a2niubslwg2iv0ej foreign key (activities_id) references activities
alter table contact add constraint FKckoarj5a5jmet3b3smgdhaopw foreign key (customer_id) references customer
alter table contact_activities_collection add constraint FK263g0m1qfqvnchdrmf0ni1jx6 foreign key (activities_collection_id) references activities
alter table contact_activities_collection add constraint FK6dqnj43w532hblpv7ckeakwdk foreign key (contact_id) references contact
alter table customer_activities_collection add constraint FKay1i8rhgb8f9hwe1fte45ampe foreign key (activities_collection_id) references activities
alter table customer_activities_collection add constraint FK62j21fri6in7dcewbg0e1suhd foreign key (customer_id) references customer
alter table medical_data add constraint FKmf6rcdttxdhe3ohwlqci1euti foreign key (customer_id) references customer
alter table subscription add constraint FKg04cmtkq431k68csu8emybpcc foreign key (customer_id) references customer
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users
create table activities (id  bigserial not null, date timestamp, description varchar(255), name varchar(255), primary key (id))
create table activities_contact_collection (activities_id int8 not null, contact_collection_id int8 not null)
create table activities_customer_collection (activities_id int8 not null, customer_collection_id int8 not null)
create table contact (id  bigserial not null, address varchar(255), company varchar(255), date_birth date, email varchar(255), name varchar(255), phone varchar(255), profession varchar(255), surname varchar(255), volunteer boolean, customer_id int8, primary key (id))
create table contact_activities_collection (contact_id int8 not null, activities_collection_id int8 not null)
create table customer (id  bigserial not null, address varchar(255), company varchar(255), date_birth date, email varchar(255), name varchar(255), phone varchar(255), profession varchar(255), surname varchar(255), volunteer boolean, primary key (id))
create table customer_activities_collection (customer_id int8 not null, activities_collection_id int8 not null)
create table medical_data (id  bigserial not null, debut_date timestamp, diabetes_type varchar(255), handicap boolean, patology varchar(255), customer_id int8, primary key (id))
create table roles (role_id  bigserial not null, name varchar(255), primary key (role_id))
create table subscription (id  bigserial not null, account varchar(255), adirmu_enddate date, adirmu_startdate date, adirmu_status boolean, cash boolean, payment_day date, periodity varchar(255), reason varchar(255), customer_id int8, primary key (id))
create table users (username varchar(255) not null, enabled boolean, password varchar(255), primary key (username))
create table users_roles (user_id varchar(255) not null, role_id int8 not null, primary key (user_id, role_id))
alter table activities_contact_collection add constraint FK5npc6t2nesrdd9q3q2d2gq2f2 foreign key (contact_collection_id) references contact
alter table activities_contact_collection add constraint FK3my12cy2fej30oyiyk4q208mh foreign key (activities_id) references activities
alter table activities_customer_collection add constraint FK77d2e734hjmlbqo7sh2x9kgj4 foreign key (customer_collection_id) references customer
alter table activities_customer_collection add constraint FKfkxx921e9a2niubslwg2iv0ej foreign key (activities_id) references activities
alter table contact add constraint FKckoarj5a5jmet3b3smgdhaopw foreign key (customer_id) references customer
alter table contact_activities_collection add constraint FK263g0m1qfqvnchdrmf0ni1jx6 foreign key (activities_collection_id) references activities
alter table contact_activities_collection add constraint FK6dqnj43w532hblpv7ckeakwdk foreign key (contact_id) references contact
alter table customer_activities_collection add constraint FKay1i8rhgb8f9hwe1fte45ampe foreign key (activities_collection_id) references activities
alter table customer_activities_collection add constraint FK62j21fri6in7dcewbg0e1suhd foreign key (customer_id) references customer
alter table medical_data add constraint FKmf6rcdttxdhe3ohwlqci1euti foreign key (customer_id) references customer
alter table subscription add constraint FKg04cmtkq431k68csu8emybpcc foreign key (customer_id) references customer
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users
create table activities (id  bigserial not null, date timestamp, description varchar(255), name varchar(255), primary key (id))
create table activities_contact_collection (activities_id int8 not null, contact_collection_id int8 not null)
create table activities_customer_collection (activities_id int8 not null, customer_collection_id int8 not null)
create table contact (id  bigserial not null, address varchar(255), company varchar(255), date_birth date, email varchar(255), name varchar(255), phone varchar(255), profession varchar(255), surname varchar(255), volunteer boolean, customer_id int8, primary key (id))
create table contact_activities_collection (contact_id int8 not null, activities_collection_id int8 not null)
create table customer (id  bigserial not null, address varchar(255), company varchar(255), date_birth date, email varchar(255), name varchar(255), phone varchar(255), profession varchar(255), surname varchar(255), volunteer boolean, primary key (id))
create table customer_activities_collection (customer_id int8 not null, activities_collection_id int8 not null)
create table medical_data (id  bigserial not null, debut_date timestamp, diabetes_type varchar(255), handicap boolean, patology varchar(255), customer_id int8, primary key (id))
create table roles (role_id  bigserial not null, name varchar(255), primary key (role_id))
create table subscription (id  bigserial not null, account varchar(255), adirmu_enddate date, adirmu_startdate date, adirmu_status boolean, cash boolean, payment_day date, periodity varchar(255), reason varchar(255), customer_id int8, primary key (id))
create table users (username varchar(255) not null, enabled boolean, password varchar(255), primary key (username))
create table users_roles (user_id varchar(255) not null, role_id int8 not null, primary key (user_id, role_id))
alter table activities_contact_collection add constraint FK5npc6t2nesrdd9q3q2d2gq2f2 foreign key (contact_collection_id) references contact
alter table activities_contact_collection add constraint FK3my12cy2fej30oyiyk4q208mh foreign key (activities_id) references activities
alter table activities_customer_collection add constraint FK77d2e734hjmlbqo7sh2x9kgj4 foreign key (customer_collection_id) references customer
alter table activities_customer_collection add constraint FKfkxx921e9a2niubslwg2iv0ej foreign key (activities_id) references activities
alter table contact add constraint FKckoarj5a5jmet3b3smgdhaopw foreign key (customer_id) references customer
alter table contact_activities_collection add constraint FK263g0m1qfqvnchdrmf0ni1jx6 foreign key (activities_collection_id) references activities
alter table contact_activities_collection add constraint FK6dqnj43w532hblpv7ckeakwdk foreign key (contact_id) references contact
alter table customer_activities_collection add constraint FKay1i8rhgb8f9hwe1fte45ampe foreign key (activities_collection_id) references activities
alter table customer_activities_collection add constraint FK62j21fri6in7dcewbg0e1suhd foreign key (customer_id) references customer
alter table medical_data add constraint FKmf6rcdttxdhe3ohwlqci1euti foreign key (customer_id) references customer
alter table subscription add constraint FKg04cmtkq431k68csu8emybpcc foreign key (customer_id) references customer
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users
