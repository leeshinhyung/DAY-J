insert into app_user (id, password) values (1, 'aaa-zzzz-ddddd');
insert into app_user (id, password) values (2, 'aaa-zzzz-ddddd');

insert into friend_group (id, group_goal, group_name, group_exit) values (1, 'Hyundai', 'Mazda', true);
insert into friend_group (id, group_goal, group_name, group_exit) values (2, 'Volkswagen', 'Ford', true);

insert into plan (id, is_complete, plan_alarm_date, plan_create_date, plan_tag, goal, plan_photo, plan_time, plan_day) values (1, false, '2023-01-14', '2023-01-14', 'Nissan', 'Chevrolet', 'Volvo', '2023-01-14', '2023-01-14');
insert into plan (id, is_complete, plan_alarm_date, plan_create_date, plan_tag, goal, plan_photo, plan_time, plan_day) values (2, true, '2023-01-14', '2023-01-14', 'Lexus', 'Toyota', 'Infiniti', '2023-01-14', '2023-01-14');

insert into setting (id, nickname, plan_alarm, friend_group_alarm, post_alarm, app_alarm, profile_photo) values (1, 'Kia', false, false, false, false, 'Mitsubishi');
insert into setting (id, nickname, plan_alarm, friend_group_alarm, post_alarm, app_alarm, profile_photo) values (2, 'Volkswagen', false, false, false, true, 'Jeep');

insert into post (id, post_view, post_like, post_content, post_date, post_is_anonymous, comment_is_anonymous, post_photo) values (1, 1, 1, 'Toyota', '2023-01-14', false, false, 'Chevrolet');
insert into post (id, post_view, post_like, post_content, post_date, post_is_anonymous, comment_is_anonymous, post_photo) values (2, 1, 1, 'Toyota', '2023-01-14', false, false, 'Chevrolet');
