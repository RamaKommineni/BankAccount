CREATE TABLE account_user (
  "id"     BIGINT,
  "login_name"   VARCHAR(255) NOT NULL UNIQUE,
  "status" VARCHAR(10),
  
  "updated_at"  timestamptz default now(),
  "updated_by"  VARCHAR(255),
  "notes"       VARCHAR(255),
  "created_at"  timestamptz default now(),
  "created_by"  VARCHAR(255),
  PRIMARY KEY ("id")
);

CREATE SEQUENCE public.account_user_seq INCREMENT 1 START 1 MINVALUE 1;


create table account_type(
  "id"     BIGINT,
  "name"   varchar(10),
  "description" varchar(255),
  "status" varchar(10),
  
  "updated_at"  timestamptz default now(),
  "updated_by"  VARCHAR(255),
  "notes"       VARCHAR(255),
  "created_at"  timestamptz default now(),
  "created_by"  VARCHAR(255),
  PRIMARY KEY ("id")
);

CREATE SEQUENCE account_type_seq INCREMENT 1 START 1 MINVALUE 1;

INSERT INTO account_type
(id, "name", description, status)
VALUES(nextval('account_type_seq'), 'SAVINGS', 'Savings Account Type', 'ACTIVE');

INSERT INTO account_type
(id, "name", description, status)
VALUES(nextval('account_type_seq'), 'CURRENT', 'Current Account Type', 'ACTIVE');

create table account(
	"id"     BIGINT,
	"account_user_id" BIGINT references account_user(id),
	"account_number" BIGINT unique,
	"account_name" varchar(20),
	"account_type_id" BIGINT references account_type(id) NOT NULl,
	"balance_date" date,
	"currency" varchar(4),
	"balance" Float(2),
	
  	"updated_at"  timestamptz default now(),
  	"updated_by"  VARCHAR(255),
  	"notes"       VARCHAR(255),
  	"created_at"  timestamptz default now(),
  	"created_by"  VARCHAR(255),
  	PRIMARY KEY ("id")
);

CREATE SEQUENCE account_seq INCREMENT 1 START 1 MINVALUE 1;


create table transaction_type(
  "id"     BIGINT,
  "name"   varchar(10),
  "description" varchar(255),
  "status" varchar(10),
  
  "updated_at"  timestamptz default now(),
  "updated_by"  VARCHAR(255),
  "notes"       VARCHAR(255),
  "created_at"  timestamptz default now(),
  "created_by"  VARCHAR(255),
  PRIMARY KEY ("id")
);

CREATE SEQUENCE transaction_type_seq INCREMENT 1 START 1 MINVALUE 1;

INSERT INTO transaction_type
(id, "name", description, status)
VALUES(nextval('account_type_seq'), 'CREDIT', 'Credit Transaction Type', 'ACTIVE');

INSERT INTO transaction_type
(id, "name", description, status)
VALUES(nextval('account_type_seq'), 'DEBIT', 'Debit Transaction Type', 'ACTIVE');

create table account_transaction(
	"id"     BIGINT,
	"account_id" BIGINT references account(id),
	"value_date" date,
	"debit_amount" Float(2),
	"credit_amount" Float(2),
	"transaction_type" BIGINT references transaction_type(id),
	"narrative" varchar(255),
	
  	"updated_at"  timestamptz default now(),
  	"updated_by"  VARCHAR(255),
  	"notes"       VARCHAR(255),
  	"created_at"  timestamptz default now(),
  	"created_by"  VARCHAR(255),
  	PRIMARY KEY ("id")
);

CREATE SEQUENCE account_transaction_seq INCREMENT 1 START 1 MINVALUE 1;