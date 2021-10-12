create schema employee_schema;

create table employee_schema.employees (
    employee_id bigserial primary key not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    department_id bigint not null,
    job_title varchar(255) not null,
    gender varchar(255) not null,
    date_of_birth date not null
);

insert into employee_schema.employees values(default, 'test1', 'test1', 1, 'test', 'FEMALE', '2000-10-01');


