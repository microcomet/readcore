# 创建数据库
create database if not exists clean_read_toggle character set utf8 collate utf8_general_ci;

# 将某一数据库上的所有权限都赋给某一用户
grant all on clean_read_toggle.* to 'cleaner'@'%';

# 查询当前数据库支持的所有character set和配套对应字符集的默认collate（排序规则）
# show charset;

create database if not exists clean_read character set utf8 collate utf8_general_ci;
truncate table clean_read.book;
truncate table clean_read.book_category;
truncate table clean_read.chapter;
truncate table clean_read.user;
truncate table clean_read.volume;