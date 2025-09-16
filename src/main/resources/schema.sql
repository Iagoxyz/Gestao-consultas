create table atendimento_procedimento (
    atendimento_id bigint not null,
    procedimento_id bigint not null,
    engine=InnoDB
);

create table tb_atendimento (
    id bigint not null auto_increment,
    date_time datetime(6),
    plan_number varchar(255),
    tipo enum ('PARTICULAR','PLANO'),
    valor_total decimal(38,2),
    paciente_paciente_id bigint not null,
    usuario_id bigint not null,
    primary key (id),
    engine=InnoDB
);

create table tb_paciente (
    paciente_id bigint not null auto_increment,
    data_nascimento date,
    bairro varchar(255),
    cep varchar(255),
    cidade varchar(255),
    estado varchar(255),
    numero varchar(255),
    rua varchar(255),
    paciente_cpf varchar(255),
    paciente_email varchar(255),
    paciente_nome varchar(255),
    paciente_telefone varchar(255),
    cpf varchar(255),
    date_of_birth varchar(255),
    email varchar(255),
    nome varchar(255),
    telefone varchar(255),
    primary key (paciente_id),
    engine=InnoDB
);

create table tb_procedimento (
    procedimento_id bigint not null auto_increment,
    descricao varchar(255),
    nome varchar(255),
    valor_particular decimal(38,2),
    valor_plan decimal(38,2),
    primary key (procedimento_id),
    engine=InnoDB
);

create table tb_user (
    user_id bigint not null auto_increment,
    email varchar(255),
    nome varchar(255),
    senha varchar(255),
    primary key (user_id),
    engine=InnoDB
);

alter table tb_paciente add constraint UKpjwef767lxgmfcq4hwg8xfdxe unique (paciente_cpf);
alter table tb_paciente add constraint UKqjp312t9duv8amj0mrnr8pdt0 unique (paciente_email);
alter table tb_user add constraint UK4vih17mube9j7cqyjlfbcrk4m unique (email);

alter table atendimento_procedimento
    add constraint FKqqmcinp3gcj2km49fdfeoyk48
    foreign key (procedimento_id) references tb_procedimento (procedimento_id);

alter table atendimento_procedimento
    add constraint FKi2fsv1tob2oo5625lp9k84oju
    foreign key (atendimento_id) references tb_atendimento (id);

alter table tb_atendimento
    add constraint FKlf98ls3hx7tt1vggi1k089c39
    foreign key (paciente_paciente_id) references tb_paciente (paciente_id);

alter table tb_atendimento
    add constraint FKjsymr4bnjndsbmmkfuycs5nl0
    foreign key (usuario_id) references tb_user (user_id);