INSERT INTO account_type
(ID, name, description, status)
VALUES(nextval('account_type_seq'), 'SAVINGS', 'Savings Account Type', 'ACTIVE');

INSERT INTO account_type
(ID, name, description, status)
VALUES(nextval('account_type_seq'), 'CURRENT', 'Current Account Type', 'ACTIVE');

INSERT INTO transaction_type
(id, name, description, status)
VALUES(nextval('account_type_seq'), 'CREDIT', 'Credit Transaction Type', 'ACTIVE');

INSERT INTO transaction_type
(id, name, description, status)
VALUES(nextval('account_type_seq'), 'DEBIT', 'Debit Transaction Type', 'ACTIVE');

INSERT INTO public.account_user
(id, login_name, status) VALUES(nextval('account_user_seq'), 'rama@gmail.com', 'ACTIVE');

INSERT INTO public.account
(id, account_user_id, account_number, account_name, account_type_id, balance_date, currency, balance)
VALUES(nextval('account_seq'), (select id from account_user where login_name='rama@gmail.com'), 585309209, 'SGSavings726', (select id from account_type where name='SAVINGS'), '2019-12-06', 'SGD', 84327.00);

INSERT INTO public.account
(id, account_user_id, account_number, account_name, account_type_id, balance_date, currency, balance)
VALUES(nextval('account_seq'), (select id from account_user where login_name='rama@gmail.com'), 791066619, 'AUSavings933', (select id from account_type where name='SAVINGS'), '2019-12-06', 'AUD', 98748.00);

INSERT INTO public.account
(id, account_user_id, account_number, account_name, account_type_id, balance_date, currency, balance)
VALUES(nextval('account_seq'), (select id from account_user where login_name='rama@gmail.com'), 321143048, 'AUCurrent433', (select id from account_type where name='CURRENT'), '2019-12-06', 'SGD', 84327.00);

INSERT INTO public.account_transaction
(id, account_id, value_date, debit_amount, credit_amount, transaction_type_id)
VALUES(nextval('account_transaction_seq'), (select id from account where account_number='585309209'), '2019-12-03', NULL, 9540.89, (select id from transaction_type where name='CREDIT'));

INSERT INTO public.account_transaction
(id, account_id, value_date, debit_amount, credit_amount, transaction_type_id)
VALUES(nextval('account_transaction_seq'), (select id from account where account_number='585309209'), '2019-12-03', 7123.89, null,(select id from transaction_type where name='DEBIT'));




