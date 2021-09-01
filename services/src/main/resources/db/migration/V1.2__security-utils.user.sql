create table security_utils.user
(
    user_id uuid
        constraint user_id_pk
            primary key,
    login       varchar(50)
        constraint login_uk
            unique,
    email varchar(50)
        constraint email_uk
            unique,
    name varchar(50),
    password        varchar(50)
);