INSERT INTO app_user(nickname, password, profile_photo)
VALUES('admin', 'dummy', 'what');

INSERT INTO friend_group(group_name, group_goal)
VALUES('capstone', 'idk..');

INSERT INTO plan(plan_alarm_date, plan_create_date, plan_tag, goal, plan_photo, plan_time, plan_day)
VALUES('2007-12-03', '2007-12-03', 'tag', 'goal', 'plan photo', '2007-12-03', '2007-12-03');

INSERT INTO post(post_view, post_like, post_content, post_name, post_tag, post_comment, post_date, post_comment_date, comment_is_anonymous, post_photo)
VALUES(3,4,'content', 'name', 'tag', 'comment', '2007-12-03', '2007-12-03', true, 'photo');
