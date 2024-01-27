-- CREATE TABLES;
CREATE TABLE IF NOT EXISTS public.client
(
    cod_client SERIAL NOT NULL,
    start_date date default current_date,
    account_num varchar(50),
    dui varchar(45),
    name varchar(50),
    surname varchar(50),
    CONSTRAINT pkey_client PRIMARY KEY (cod_client)
);

CREATE TABLE IF NOT EXISTS public.account
(
    account_number varchar(10) NOT NULL,
    cod_client integer,
    opening_mount decimal(10,2),
    start_date date default current_date,
    account_name varchar(50),
    account_statement varchar(1),
    balance decimal(10,2),

	CONSTRAINT pkey_account PRIMARY KEY (account_number)
);

CREATE TABLE IF NOT EXISTS public.transaction
(
    transaction_id SERIAL NOT NULL,
    amount decimal(10,2),
    transaction_type_id integer,
    date Date default current_date,
    account_num varchar(10),
    CONSTRAINT pkey_transaction PRIMARY KEY (transaction_id)
);

CREATE TABLE IF NOT EXISTS public.transaction_type
(
    transaction_type_id integer,
    transaction_name varchar(100),

	CONSTRAINT pkey_type_id PRIMARY KEY (transaction_type_id)
);

insert into public.transaction_type(transaction_type_id, transaction_name) values (1, 'Deposito');
insert into public.transaction_type(transaction_type_id, transaction_name) values (2, 'Retiro');

-- FUNCIONES

CREATE OR REPLACE FUNCTION public.set_amount()
RETURNS TRIGGER AS
$$
BEGIN
    UPDATE public.account
    SET balance = balance + NEW.amount
    WHERE account_number = NEW.account_num;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger en el esquema public
CREATE TRIGGER set_amount
AFTER INSERT ON public.transaction
FOR EACH ROW
EXECUTE FUNCTION public.set_amount();
